package com.xgb.java.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Client_Test {
    public static void main(String[] args) throws UnknownHostException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                port = 8080;
            }
        }
        new Thread(new TimeClientHandle("127.0.0.1", port), "Time-Client-001").start();
    }
}
class TimeClientHandle implements Runnable{
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    //Ĭ��booleanֵΪfalse
    private volatile boolean stop;

    public TimeClientHandle(String host, int port) {
        //host��Ϊ�գ�������Ϊָ��ip
        this.host = host == null ? "127.0.0.1" : host;
        this.port = port;
        try {
            //�򿪶�·������
            selector = Selector.open();
            //�򿪹ܵ�
            socketChannel = SocketChannel.open();
            //���ùܵ�Ϊ������ģʽ
            socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!stop) {
            try {
                //�����ȴ�1s������ʱ�򷵻�
                selector.select(1000);
                //��ȡ����selectionkey
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                //��������selectionkey
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()) {
                    key = it.next();
                    //��ȡ֮��ɾ��
                    it.remove();
                    try {
                        //�����selectionkey
                        handleInput(key);
                    } catch (Exception e) {
                        if (key != null) {
                            //ȡ��selectionkey
                            key.cancel();
                            if (key.channel() != null) {
                                //�رո�ͨ��
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (selector != null) {
            try {
                //�رն�·������
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleInput(SelectionKey key) throws IOException{
        //����selectorkey����
        if (key.isValid()) {
            //��keyת��ΪSocketChannel
            SocketChannel sc = (SocketChannel) key.channel();
            //�ж��Ƿ����ӳɹ�
            if (key.isConnectable()) {
                //���Ѿ���������
                if (sc.finishConnect()) {
                    //���·������ע��ɶ��¼�
                    sc.register(selector, SelectionKey.OP_READ);
                    //��ܵ�д����
                    doWrite(sc);
                }else {
                    //����ʧ�� �����˳�
                    System.exit(1);
                }
            }

            //���ǿɶ����¼�
            if (key.isReadable()) {
                //����һ��������
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                System.out.println("before  :  "+readBuffer);
                //�ӹܵ��ж�ȡ����Ȼ��д�뻺������
                int readBytes = sc.read(readBuffer);
                System.out.println("after :  "+readBuffer);
                //��������
                if (readBytes > 0) {
                    //��ת������
                    readBuffer.flip();
                    System.out.println(readBuffer);

                    byte[] bytes = new byte[readBuffer.remaining()];
                    //��ȡ��������д���ֽ�������
                    readBuffer.get(bytes);
                    //���ֽ�����ת��ΪString����
                    String body = new String(bytes);
                    System.out.println(body.length());
                    System.out.println("Now is : " + body + "!");
                    this.stop = true;
                } else if (readBytes < 0) {
                    key.cancel();
                    sc.close();
                } else {
                    sc.register(selector, SelectionKey.OP_READ);
                }
            }
        }
    }
    public void doConnect() throws IOException {
        //ͨ��ip�Ͷ˿ں����ӵ�������
        if (socketChannel.connect(new InetSocketAddress(host, port))) {
            //���·������ע��ɶ��¼�
            socketChannel.register(selector, SelectionKey.OP_READ);
            //��ܵ�д����
            doWrite(socketChannel);
        } else {
            //�����ӷ�����ʧ��,�����·������ע�������¼�
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
    }
    private void doWrite(SocketChannel sc) throws IOException {
        //Ҫд������
        byte[] req = "    -    QUERY TIME ORDER     -   ".getBytes();
        //Ϊ�ֽڻ���������ָ���ֽڴ�С������
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        //������д�뻺����
        writeBuffer.put(req);
        //��ת������
        writeBuffer.flip();
        //�����ӡ�������Ŀɶ���С
        System.out.println(writeBuffer.remaining());
        //������д��ܵ���
        sc.write(writeBuffer);
        if (!writeBuffer.hasRemaining()) {
            //�����������޿ɶ��ֽڣ���˵���ɹ����͸���������Ϣ
            System.out.println("Send order 2 server succeed.");
        }
    }

}
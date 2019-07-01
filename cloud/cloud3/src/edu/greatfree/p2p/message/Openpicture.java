package edu.greatfree.p2p.message;

import javax.swing.*;
import java.io.File;

public class Openpicture extends JFrame {
//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> {
//            // TODO Auto-generated method stub
//            JFrame frame = new Openpicture();
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//        });
//    }

    private JLabel label;
    private JFileChooser chooser;
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;

    public Openpicture() {
        setTitle("ImageViewer");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        label = new JLabel();
        add(label);
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        label.setIcon(new ImageIcon("C:" + File.separator + "Users" + File.separator + "acer" + File.separator + "Desktop" + File.separator + "yun.jpg"));
//图片路径："C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun.jpg";

    }
}


//class ImageViewerFrame extends JFrame {
//    private JLabel label;
//    private JFileChooser chooser;
//    private static final int DEFAULT_WIDTH = 400;
//    private static final int DEFAULT_HEIGHT = 300;
//
//    public ImageViewerFrame() {
//        setTitle("ImageViewer");
//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
//        label = new JLabel();
//        add(label);
//        chooser = new JFileChooser();
//        chooser.setCurrentDirectory(new File("."));
//        JMenuBar menubar = new JMenuBar();
//        setJMenuBar(menubar);
//        label.setIcon(new ImageIcon("C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun.jpg"));
////图片路径："C:"+File.separator+"Users"+File.separator+"acer"+File.separator+"Desktop"+File.separator+"yun.jpg";
//
//    }
//}

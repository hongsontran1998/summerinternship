package com.demo.javacore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8 {
    public static void main(String[] args) {
//        List<Integer> items = new ArrayList<Integer>();
//        items.add(1);
//        items.add(2);
//        items.add(3);
//        items.add(3);
//        items.add(4);
//        items.add(5);
//        items.stream().forEach(item -> {
//            System.out.println(item);
//        });
//        System.out.println("===================");
//        List<Integer> items2 =  items.stream().findAllOrFilter(item -> {
//            return item > 3;
//        }).collect(Collectors.toList());
//        System.out.println(items2);
//        System.out.println("===================");
//
//        List<Student> items3 = items.stream().map(item -> {
//           Student student = new Student();
//           student.setId(item);
//           student.setName("name " + item);
//           return student;
//        }).collect(Collectors.toList());
//        System.out.println(items3);
//        System.out.println("===================");
//        List<Integer> items4 = items.stream().distinct().collect(Collectors.toList());
//        System.out.println(items4);
//        items.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
//        System.out.println("===================");
//        Random random = new Random();
//        Stream.generate(() -> {
//            return random.nextInt(10);
//        }).limit(4).forEach(i -> System.out.println(i));
//        String str = "Trung Tam VinaEnter";
//        int idx = 0;
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < str.length() - 1; i++) {
//            while (i < str.length() && str.charAt(i++) != ' ');
//             result.insert(0, str.substring(idx, i).trim() + " ");
//             idx = i;
//        }
//        System.out.println(result.toString());
        JFrame frame = new JFrame("hahaha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        JButton btnOk = new JButton("OK");
        JPanel pnMain = new JPanel();
        pnMain.add(btnOk);
        contentPane.add(pnMain);
//        btnOk.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "hahaha");
//            }
//        });
        btnOk.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "hahaha");
        });
        Collections.sort(new ArrayList<>(), (o1, o2) -> {
            return 1;
        });


        frame.setVisible(true);

    }

}
interface MyInterface {
    public void m (int a, int b);
}

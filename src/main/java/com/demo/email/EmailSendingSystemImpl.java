package com.demo.email;

import com.demo.entity.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class EmailSendingSystemImpl implements EmailSendingSystem {

    //cấu hình props bên application.properties rồi thì ko cần tạo bean nữa
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private Configuration freemarkerConfig;
    /*không cần tạo bean spring lo rồi: click vào mũi tên bên thanh trái để xem bean này đến từ đâu*/

    @Override
    public void sendWithVelocity() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "title");
        model.put("body", "body");
        User user = new User();
        user.setUsername("Hồng Sơn Trần");
        model.put("user", user);

        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/email.vm",
                "UTF-8", model);
        //System.out.println(text);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("tigersama2205@gmail.com");
        int rand = new Random().nextInt(100);
        String address = "tigersama2205+" + rand + "@gmail.com";
        System.out.println(address);
        mimeMessageHelper.setTo(address);
        mimeMessageHelper.setSubject("email submit");
        mimeMessageHelper.setText(text, true);

        //file attachment
        try {
            File file =  ResourceUtils.getFile("classpath:static/abc.png");
            mimeMessageHelper.addAttachment("xxx.png", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }

    @Override
    public void sendWithFreemarker() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "my title");
        model.put("body", "mybody");
        User user = new User();
        user.setUsername("sonthh");
        model.put("user", user);
        model.put("location", "Belgium");
        model.put("signature", "https://memorynotfound.com");
        model.put("logo", ResourceUtils.getFile("classpath:static/abc.png"));

        Template t = freemarkerConfig.getTemplate("email.ftl");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
        //System.out.println(text);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("tigersama2205@gmail.com");
        int rand = new Random().nextInt(100);
        String address = "tigersama2205+" + rand + "@gmail.com";
        System.out.println(address);
        mimeMessageHelper.setTo(address);
        mimeMessageHelper.setSubject("email submit");
        mimeMessageHelper.setText(text, true);

        //file attachment
        try {
            File file =  ResourceUtils.getFile("classpath:static/abc.png");
            mimeMessageHelper.addAttachment("xxx.png", file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }
}

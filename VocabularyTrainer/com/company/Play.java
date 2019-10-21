package com.company;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// Учебная программа для тренировки и запоминания
// слов английского языка

// Разработал Эдуард Антон
// 20 октября 2019

public class Play extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Vocabulary trainer";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 370;
    final int WINDOW_HEIGHT = 450;

    JLabel label;
    JTextPane windowDialog;
    JTextField answer;
    SimpleAttributeSet styleAnswer;
    JButton button1;
    JButton button2;
    Trainer trainer = new Trainer();

    public static void main(String[] args) throws FileNotFoundException {

        new Play();
    }

    // конструктор для создания окна программы
    Play() throws FileNotFoundException {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);

        // диалоговое окно
        windowDialog = new JTextPane();
        windowDialog.setContentType("text/html");
        JScrollPane scrollBar = new JScrollPane(windowDialog);
        windowDialog.setToolTipText("Набери \"exit\" для окончания и просмотра результата");

        // прописываем порядок вывода сообщений от программы
        styleAnswer = new SimpleAttributeSet();
        StyleConstants.setItalic(styleAnswer, true);
        StyleConstants.setForeground(styleAnswer, Color.blue);
        StyleConstants.setAlignment(styleAnswer, StyleConstants.ALIGN_RIGHT);

        // создаем панель и ее элементы (кнопки, окно ввода и т.д.)
        label = new JLabel(trainer.printRecordsAmount());
        //label.setHorizontalTextPosition(label.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        answer = new JTextField();
        answer.addActionListener(this);
        answer.setToolTipText("Введи сюда перевод");
        button1 = new JButton("Новое слово");
        button1.addActionListener(this);
        button1.setToolTipText("Нажми для выода слова");
        button2 = new JButton("Проверить");
        button2.addActionListener(this);
        button2.setToolTipText("Нажми для проверки слова");

        // собираем все элементы
        panel.add(button1);
        panel.add(answer);
        panel.add(button2);
        add(BorderLayout.NORTH, label);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, panel);
        setVisible(true);
    }

    // определяем метод обработки событий нажатия на кнопки
    @Override
    public void actionPerformed(ActionEvent event) {
            try {
                StyledDocument document = windowDialog.getStyledDocument();
                if(event.getSource() == button1) {
                    document.insertString(document.getLength(), "Trainer: " +
                            trainer.trainerStart(answer.getText()) + "\n", styleAnswer);
                }
                if(event.getSource() == button2) {
                    document.insertString(document.getLength(), answer.getText() + "\n",
                            new SimpleAttributeSet());

                    document.insertString(document.getLength(), "Trainer: " +
                            trainer.getTranslate(answer.getText()) + "\n", styleAnswer);
                }

            }catch (Exception e) {
                e.printStackTrace();
            }

        // Очищаем поле ввода и фокусируем в него кусор
        answer.setText("");
        answer.requestFocusInWindow();
    }
}

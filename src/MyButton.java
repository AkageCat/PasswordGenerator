import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(Icon icon) {
        super(icon);
        setFocusPainted(false); // Убираем фокусные линии
        setContentAreaFilled(false); // Отключаем стандартное заполнение
        setOpaque(true); // Для того чтобы фоновый цвет применился
        setMargin(new Insets(0, 0, 0, 0));
    }

    public MyButton(String text) {
        super(text);
        setFocusPainted(false); // Убираем фокусные линии
        setContentAreaFilled(false); // Отключаем стандартное заполнение
        setOpaque(true); // Для того чтобы фоновый цвет применился
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Установка цвета фона
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Установка цвета текста
        g.setColor(Color.WHITE);
        g.setFont(getFont());

//        // Отображение текста по центру
//        FontMetrics fm = g.getFontMetrics();
//        String text = getText();
//        int textWidth = fm.stringWidth(text);
//        int textHeight = fm.getAscent();
//        int x = (getWidth() - textWidth) / 2;
//        int y = (getHeight() + textHeight) / 2 - fm.getDescent();
//
//        g.drawString(text, x, y);
    }
}

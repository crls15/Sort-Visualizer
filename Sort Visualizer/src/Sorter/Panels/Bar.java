package Sorter.Panels;

import Sorter.*;

import javax.swing.JPanel;
import java.awt.Color;

public class Bar extends JPanel
{
    private int value;
    private int arrayPosition;

    private int barWidth;
    private int barHeight;

    private int positionX;
    private int positionY;

    public Color barColor;

    public Bar(int value, int numOfBars, int windowWidth, int windowHeight, int maxDrawHeight)
    {
        super(true);

        setValue(value);
        setArrayPosition(value);

        setBarWidth((int)windowWidth/numOfBars);

        double barPercentMaxHeight=(maxDrawHeight/numOfBars);
        setBarHeight((value+1)* ( (int)barPercentMaxHeight ) +50);

        setPositionX(arrayPosition*barWidth);
        setPositionY(windowHeight-barHeight);

        setLayout(null);
        setBounds(positionX, positionY, barWidth, barHeight);
        setBarColor(Color.WHITE);

    }

    public void replaceBar()
    {
        this.setBounds(positionX, positionY, barWidth, barHeight);
        this.setBackground(Color.WHITE);
    }

    //To change position and colors
    public void swapBar(int newArrayPosition, int miliSec)
    {
        setBarColor(Color.RED);
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        setBarColor(Color.DARK_GRAY);

        setArrayPosition(newArrayPosition);
        setPositionX(arrayPosition*barWidth);
        repaint();

    }

    public void selectBar(int miliSec)
    {
        setBarColor(Color.BLUE);
        try {
            Thread.sleep(miliSec);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        repaint();
    }

    public void deselectBar()
    {
        setBarColor(Color.WHITE);
        repaint();
    }


    //Setters
    public void setValue(int value)
    {
        this.value = value;
    }

    public void setArrayPosition(int arrayPosition) {
        this.arrayPosition = arrayPosition;
    }


    public void setBarWidth(int barWidth) {
        this.barWidth = barWidth;
    }

    public void setBarHeight(int barHeight) {
        this.barHeight = barHeight;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setBarColor(Color barColor) {
        this.barColor = barColor;
        this.setBackground(barColor);
        repaint();
    }


    //Getters
    public int getValue() {
        return value;
    }

    public int getArrayPosition() {
        return arrayPosition;
    }

}

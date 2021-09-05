package Sorter.Panels;

import Sorter.*;
import Sorter.Actions.ActionTotalBars;
import Sorter.Enums.EnumBars;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;

public class TotalBarsPanel extends JPanel
{
    private JButton button10;
    private JButton button50;
    private JButton button100;
    private JButton button200;
    private JButton button600;
    private JButton lessSpeedButton;
    private JButton slowButton;
    private JButton mediumButton;
    private JButton fastButton;
    private JButton defaultButton;


    public TotalBarsPanel(MenuWindow sorterFrame)
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.GRAY);

        button10 = new JButton("10 Bars");
        this.add(button10);

        button50 = new JButton("50 Bars");
        this.add(button50);

        button100 = new JButton("100 Bars");
        this.add(button100);

        button200 = new JButton("200 Bars");
        this.add(button200);

        button600 = new JButton("600 Bars");
        this.add(button600);


        lessSpeedButton = new JButton("Less Speed");
        this.add(lessSpeedButton);

        slowButton = new JButton("Slow");
        this.add(slowButton);

        //mediumButton = new JButton("Medium");
        //this.add(mediumButton);

        defaultButton = new JButton("Default Speed");
        this.add(defaultButton);

        fastButton = new JButton("Fast");
        this.add(fastButton);



        button10.addActionListener(new ActionTotalBars(EnumBars.BARS_10, sorterFrame));
        button50.addActionListener(new ActionTotalBars(EnumBars.BARS_50, sorterFrame));
        button100.addActionListener(new ActionTotalBars(EnumBars.BARS_100, sorterFrame));
        button200.addActionListener(new ActionTotalBars(EnumBars.BARS_200, sorterFrame));
        button600.addActionListener(new ActionTotalBars(EnumBars.BARS_600, sorterFrame));

        lessSpeedButton.addActionListener(new ActionTotalBars(EnumBars.BARS_LESS_SPEED, sorterFrame));
        slowButton.addActionListener(new ActionTotalBars(EnumBars.BARS_SLOW, sorterFrame));
        //mediumButton.addActionListener(new ActionTotalBars(EnumBars.BARS_MEDIUM, sorterFrame));
        fastButton.addActionListener(new ActionTotalBars(EnumBars.BARS_FAST, sorterFrame));
        defaultButton.addActionListener(new ActionTotalBars(EnumBars.BARS_DEFAULT, sorterFrame));


    }

}

package Sorter.Actions;

import Sorter.*;
import Sorter.Enums.EnumBars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionTotalBars implements ActionListener
{
    private EnumBars enumTotalBars;
    private MenuWindow sorterFrame;

    public ActionTotalBars(EnumBars enumTotalBars, MenuWindow sorterFrame)
    {
        super();
        this.enumTotalBars = enumTotalBars;
        this.sorterFrame = sorterFrame;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        switch(enumTotalBars)
        {
            case BARS_10:
                sorterFrame.deleteBars();
                sorterFrame.totalBarSetter(10);
                sorterFrame.setFlagTotalBars(true);
                break;

            case BARS_50:
                sorterFrame.deleteBars();
                sorterFrame.totalBarSetter(50);
                sorterFrame.setFlagTotalBars(true);
                break;

            case BARS_100:
                sorterFrame.deleteBars();
                sorterFrame.totalBarSetter(100);
                sorterFrame.setFlagTotalBars(true);
                break;

            case BARS_200:
                sorterFrame.deleteBars();
                sorterFrame.totalBarSetter(200);
                sorterFrame.setFlagTotalBars(true);
                break;

            case BARS_600:
                sorterFrame.deleteBars();
                sorterFrame.totalBarSetter(600);
                sorterFrame.setFlagTotalBars(true);
                break;

            case BARS_LESS_SPEED:
                sorterFrame.setSpeedControl(sorterFrame.getSpeedControl()+1);
                break;

            case BARS_SLOW:
                sorterFrame.setSpeedControl(8);
                break;

            //case BARS_MEDIUM:
            //sorterFrame.setSpeedControl(4);
            //break;

            case BARS_DEFAULT:
                sorterFrame.setSpeedControl(1);
                break;

            case BARS_FAST:
                sorterFrame.setSpeedControl(0);
                break;

            default:
                break;
        }

    }

}

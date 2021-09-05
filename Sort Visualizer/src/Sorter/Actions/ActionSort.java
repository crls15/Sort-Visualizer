package Sorter.Actions;

import Sorter.*;
import Sorter.Enums.EnumSortMethods;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionSort implements ActionListener
{
    private EnumSortMethods enumSortMethod;
    private MenuWindow sorterFrame;

    public ActionSort(EnumSortMethods enumSortMethod, MenuWindow sorterFrame)
    {
        super();

        this.enumSortMethod = enumSortMethod;
        this.sorterFrame = sorterFrame;
    }


    @Override
    public void actionPerformed(ActionEvent event)
    {
        switch(enumSortMethod)
        {
            case SORT_BUBBLE:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_BUBBLE);
                sorterFrame.setFlagSort(true);
                break;

            case SORT_QUICK:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_QUICK);
                sorterFrame.setFlagSort(true);
                break;

            case SORT_INSERTION:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_INSERTION);
                sorterFrame.setFlagSort(true);
                break;

            case SORT_SELECTION:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_SELECTION);
                sorterFrame.setFlagSort(true);
                break;

            case SORT_REVERSEQUICK:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_REVERSEQUICK);
                sorterFrame.setFlagSort(true);
                break;

            case SORT_OTHER:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_OTHER);
                sorterFrame.setFlagSort(true);
                break;

            case SORT_OTHER2:
                sorterFrame.setSelectedSortMethod(EnumSortMethods.SORT_OTHER2);
                sorterFrame.setFlagSort(true);
                break;


            case SORT_SHUFFLE:
                sorterFrame.setFlagShuffle(true);
                break;

            case SORT_EXIT:
                sorterFrame.setFlagExit(true);
                break;

            default:
                break;
        }


    }

}

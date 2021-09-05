package Sorter.Panels;

import Sorter.*;
import Sorter.Actions.ActionSort;
import Sorter.Enums.EnumSortMethods;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;

public class SortMethodsPanel extends JPanel
{
    private JButton shuffleButton;
    private JButton bubbleButton;
    private JButton quickButton;
    private JButton reverseQuickButton;
    private JButton insertionButton;
    private JButton selectionButton;
    private JButton otherButton;
    private JButton other2Button;
    private JButton exitButton;

    public SortMethodsPanel(MenuWindow sorterFrame)
    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.LIGHT_GRAY);

        shuffleButton = new JButton("Shuffle");
        this.add(shuffleButton);

        bubbleButton = new JButton("Bubble Sort");
        this.add(bubbleButton);

        quickButton = new JButton("Quick Sort");
        this.add(quickButton);

        reverseQuickButton = new JButton("Reverse Q Sort");
        this.add(reverseQuickButton);

        insertionButton = new JButton("Insertion Sort");
        this.add(insertionButton);

        selectionButton = new JButton("Selection Sort");
        this.add(selectionButton);

        otherButton = new JButton("Other Sort");
        this.add(otherButton);

        other2Button = new JButton("Other2 Sort");
        this.add(other2Button);

        exitButton = new JButton("Exit");
        this.add(exitButton);

        shuffleButton.addActionListener(new ActionSort(EnumSortMethods.SORT_SHUFFLE, sorterFrame));
        bubbleButton.addActionListener(new ActionSort(EnumSortMethods.SORT_BUBBLE, sorterFrame));
        quickButton.addActionListener(new ActionSort(EnumSortMethods.SORT_QUICK, sorterFrame));
        reverseQuickButton.addActionListener(new ActionSort(EnumSortMethods.SORT_REVERSEQUICK, sorterFrame));
        insertionButton.addActionListener(new ActionSort(EnumSortMethods.SORT_INSERTION, sorterFrame));
        selectionButton.addActionListener(new ActionSort(EnumSortMethods.SORT_SELECTION, sorterFrame));
        otherButton.addActionListener(new ActionSort(EnumSortMethods.SORT_OTHER, sorterFrame));
        other2Button.addActionListener(new ActionSort(EnumSortMethods.SORT_OTHER2, sorterFrame));
        exitButton.addActionListener(new ActionSort(EnumSortMethods.SORT_EXIT, sorterFrame));

    }

}

package Sorter;

import App.*;

import Sorter.Enums.EnumSortMethods;
import Sorter.Panels.Bar;
import Sorter.Panels.SortMethodsPanel;
import Sorter.Panels.TotalBarsPanel;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class MenuWindow extends JFrame
{
    private TotalBarsPanel totalBarsPanel;
    private SortMethodsPanel sortMethodsPanel;
    private JLabel swapCounterLabel;
    private JLabel comparationCounterLabel;
    private int countSwaps;
    private int countComparations;

    private boolean flagTotalBars=false;
    private boolean flagExit=false;
    private boolean flagSort=false;
    private boolean flagShuffle=false;

    private int speedControl=1;

    private EnumSortMethods selectedSortMethod= EnumSortMethods.SORT_NONE;

    public final int WIN_WIDTH=1200;
    public final int WIN_HEIGHT=800;

    private int MENU_HEIGHT=65;

    public int totalBars;
    Bar barArray[];

    public MenuWindow(MainApp sorterApp)
    {
        setSize(WIN_WIDTH+15, WIN_HEIGHT);
        getContentPane().setBackground(Color.DARK_GRAY);
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Sorter");

        addTotalBarsPanel();
        addSortMethodsPanel();

        addSwapCounter();
        addComparatorCounter();

        totalBarSetter(100);

    }

    private void addSwapCounter()
    {
        swapCounterLabel = new JLabel("Swap Counter: "+ countSwaps);
        swapCounterLabel.setBounds(5, MENU_HEIGHT, WIN_WIDTH-50, 32);
        swapCounterLabel.setForeground(Color.WHITE);
        swapCounterLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(swapCounterLabel);
    }

    private void addComparatorCounter()
    {
        comparationCounterLabel = new JLabel("Comparations Counter: "+ countSwaps);
        comparationCounterLabel.setBounds(5, MENU_HEIGHT+25, WIN_WIDTH-50, 32);
        comparationCounterLabel.setForeground(Color.WHITE);
        comparationCounterLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        this.add(comparationCounterLabel);
    }

    private void addTotalBarsPanel()
    {
        int menuTotalBarsPanelWidth=(int)(WIN_WIDTH*0.4);
        totalBarsPanel = new TotalBarsPanel(this);
        totalBarsPanel.setBounds(0, 0, menuTotalBarsPanelWidth,MENU_HEIGHT);
        this.add(totalBarsPanel);
    }

    private void addSortMethodsPanel()
    {
        int menuSortMethodsPanelWidth=(int)(WIN_WIDTH*0.6);
        sortMethodsPanel = new SortMethodsPanel(this);
        sortMethodsPanel.setBounds(WIN_WIDTH-menuSortMethodsPanelWidth, 0, menuSortMethodsPanelWidth, MENU_HEIGHT);
        this.add(sortMethodsPanel);
    }

    public void totalBarSetter(int totalBars)
    {
        this.setTotalBars(totalBars);
        this.setBarArray(totalBars);
    }

    private void setTotalBars(int totalBars) {
        this.totalBars = totalBars;
    }

    private void setBarArray(int totalBars) {
        this.barArray = new Bar[totalBars];
    }

    public void setFlagTotalBars(boolean flagTotalBars) {
        this.flagTotalBars = flagTotalBars;
    }

    public void setFlagExit(boolean flagExit) {
        this.flagExit = flagExit;
    }

    public void setFlagSort(boolean flagSort) {
        this.flagSort = flagSort;
    }

    public void setFlagShuffle(boolean flagShuffle) {
        this.flagShuffle = flagShuffle;
    }

    public void setSelectedSortMethod(EnumSortMethods selectedSortMethod) {
        this.selectedSortMethod = selectedSortMethod;
    }

    public void setSpeedControl(int speedControl) {
        this.speedControl = speedControl;
    }


    public boolean getFlagTotalBars()
    {
        return flagTotalBars;
    }

    public boolean getFlagExit()
    {
        return flagExit;
    }

    public boolean getFlagSort()
    {
        return flagSort;
    }

    public boolean getFlagShuffle()
    {
        return flagShuffle;
    }

    public EnumSortMethods getSelectedSortMethod() {
        return selectedSortMethod;
    }

    public int getSpeedControl() {
        return speedControl;
    }


    public void drawBars()
    {
        for(int i=0; i<totalBars; i++)
        {
            try {
                Thread.sleep(600/totalBars);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
            barArray[i]=new Bar(i, totalBars, WIN_WIDTH, WIN_HEIGHT, WIN_HEIGHT-150);
            add(barArray[i]);
            barArray[i].setVisible(true);
            repaint();
        }
    }

    public void deleteBars()
    {
        for(int i=0; i<totalBars; i++)
        {
            remove(barArray[i]);
            repaint();
        }
    }


    public void swapBars(int indexBar1, int indexBar2)
    {
        countSwaps++;
        swapCounterLabel.setText("Swap Counter: "+ countSwaps);
        int miliSec=(600/totalBars)*speedControl;

        int originalIndex1=barArray[indexBar1].getArrayPosition();
        int originalIndex2=barArray[indexBar2].getArrayPosition();

        barArray[indexBar1].swapBar(originalIndex2, miliSec);
        barArray[indexBar2].swapBar(originalIndex1, miliSec);

        barArray[indexBar1].replaceBar();
        barArray[indexBar2].replaceBar();

        Bar tempBar = barArray[originalIndex1];
        barArray[originalIndex1] = barArray[originalIndex2];
        barArray[originalIndex2] = tempBar;

        repaint();

    }


    public void shuffle()
    {
        Random rand = new Random();
        setSpeedControl(1);

        for(int i=0; i<totalBars*2;i++)
            swapBars(rand.nextInt(totalBars), rand.nextInt(totalBars));
        countSwaps = 0;
        countComparations = 0;
        swapCounterLabel.setText("Swap Counter: "+ countSwaps);
        comparationCounterLabel.setText("Comparations Counter: "+countComparations);
    }

    public boolean checker()
    {
        int miliSec=600/totalBars;

        for(int i=0; i<totalBars-1; i++)
        {
            if(barArray[i].getValue() > barArray[i+1].getValue())
            {
                barArray[i].setBarColor(Color.RED);
                barArray[i+1].setBarColor(Color.RED);
                return false;
            }
            else
            {
                barArray[i].setBarColor(Color.GREEN);
                barArray[i+1].setBarColor(Color.GREEN);
                try {
                    Thread.sleep(miliSec);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                }

                barArray[i].setBarColor(Color.WHITE);
                barArray[i+1].setBarColor(Color.WHITE);
            }
        }
        return true;
    }

    public void starSorting()
    {
        countSwaps = 0;
        swapCounterLabel.setText("Swap Counter: "+ countSwaps);
        countComparations = 0;
        comparationCounterLabel.setText("Comparations Counter: "+countComparations);
        switch(selectedSortMethod)
        {
            case SORT_BUBBLE:
                this.bubbleSort();
                this.checker();
                break;

            case SORT_QUICK:
                this.quickSort(0, totalBars-1);
                this.checker();
                break;

            case SORT_REVERSEQUICK:
                this.reverseQuickSort(0,totalBars-1);
                break;

            case SORT_INSERTION:
                this.insertionSort();
                this.checker();
                break;

            case SORT_SELECTION:
                this.selectionSort();
                this.checker();
                break;

            case SORT_OTHER:
                break;

            case SORT_OTHER2:
                break;

            default:
                break;

        }

    }

    public void bubbleSort()
    {
        for(int i=0; i<totalBars-1; i++)
        {
            for(int j=0; j<totalBars-i-1; j++)
            {
                countComparations++;
                comparationCounterLabel.setText("Comparations Counter: "+countComparations);
                if(barArray[j].getValue()> barArray[j+1].getValue())
                {
                    swapBars(j, j+1);
                }
            }
        }
    }

    public void quickSort( int beg, int end)
    {
        int pivotPosition=end;

        countComparations++;
        comparationCounterLabel.setText("Comparations Counter: "+countComparations);
        if(beg!=end && (end>beg || beg<end))
        {
            boolean cond=true;

            while(cond)
            {
                int rightPosition=end;
                int leftPosition=beg;

                while(barArray[leftPosition].getValue() < barArray[pivotPosition].getValue())
                {
                    countComparations++;
                    comparationCounterLabel.setText("Comparations Counter: "+countComparations);
                    leftPosition++;
                }

                while(barArray[rightPosition].getValue() >= barArray[pivotPosition].getValue())
                {
                    countComparations++;
                    comparationCounterLabel.setText("Comparations Counter: "+countComparations);
                    if(leftPosition==rightPosition)
                        break;
                    rightPosition--;
                }

                countComparations++;
                comparationCounterLabel.setText("Comparations Counter: "+countComparations);
                if(leftPosition==rightPosition)
                {
                    swapBars(pivotPosition, leftPosition);
                    pivotPosition=leftPosition;
                    cond=false;
                }
                else
                {
                    swapBars(leftPosition, rightPosition);
                    int tempPosition = leftPosition;
                    leftPosition = rightPosition;
                    rightPosition = tempPosition;
                }
            }
            quickSort(beg, pivotPosition-1);
            quickSort(pivotPosition+1, end);
        }
    }

    public void reverseQuickSort( int beg, int end)
    {
        int pivotPosition=beg;

        if(beg!=end && (end>beg || beg<end))
        {
            boolean cond=true;

            while(cond)
            {
                int rightPosition=end;
                int leftPosition=beg;

                while(barArray[rightPosition].getValue() < barArray[pivotPosition].getValue())
                {
                    rightPosition--;
                }

                while(barArray[leftPosition].getValue() >= barArray[pivotPosition].getValue())
                {
                    if(leftPosition==rightPosition)
                        break;
                    leftPosition++;
                }

                if(leftPosition==rightPosition)
                {
                    swapBars(pivotPosition, rightPosition);
                    pivotPosition=rightPosition;
                    cond=false;
                }
                else
                {
                    swapBars(rightPosition, leftPosition);
                    int tempPosition = rightPosition;
                    rightPosition = leftPosition;
                    leftPosition = tempPosition;
                }

            }
            reverseQuickSort(beg, pivotPosition-1);
            reverseQuickSort(pivotPosition+1, end);
        }
    }

    public void insertionSort()
    {
        for(int i = 1; i < totalBars; i++)
        {
            int current = barArray[i].getValue();

            int j = i -1;
            countComparations++;
            comparationCounterLabel.setText("Comparations Counter: "+countComparations);
            while( j >= 0 && current < barArray[j].getValue())
            {
                countComparations++;
                comparationCounterLabel.setText("Comparations Counter: "+countComparations);
                swapBars(j+1, j);
                j--;
            }
        }
    }

    public void selectionSort()
    {
        for(int i = 0; i < totalBars; i++)
        {
            int min = barArray[i].getValue();
            int minId = i;

            for(int j = i+1; j < totalBars; j++)
            {
                countComparations++;
                comparationCounterLabel.setText("Comparations Counter: "+countComparations);
                if (barArray[j].getValue() < min)
                {
                    min = barArray[j].getValue();
                    minId = j;
                }
            }

            swapBars(i, minId);
        }
    }

}


package App;

import Sorter.*;
import Sorter.Enums.EnumSortMethods;

public class MainApp
{
    MenuWindow mainWindow;

    public void starApp()
    {
        mainWindow = new MenuWindow(this);
        mainWindow.setVisible(true);
        mainWindow.drawBars();
    }

    public void startLoop() //throws InterruptedException
    {
        boolean running=true;

        while(running)
        {
            if(mainWindow.getFlagExit())
                running=false;

            if(mainWindow.getFlagTotalBars())
            {
                mainWindow.drawBars();
                mainWindow.setFlagTotalBars(false);
            }
            else
            {
                if(mainWindow.getFlagShuffle())
                {
                    mainWindow.shuffle();
                    mainWindow.setFlagShuffle(false);

                }

                if(mainWindow.getFlagSort())
                {

                    mainWindow.starSorting();
                    mainWindow.setSelectedSortMethod(EnumSortMethods.SORT_NONE);
                    mainWindow.setFlagSort(false);
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }

        System.exit(0);
    }


    public static void main(String[] args) //throws InterruptedException
    {
        MainApp sortApp = new MainApp();
        sortApp.starApp();
        sortApp.startLoop();

    }

}
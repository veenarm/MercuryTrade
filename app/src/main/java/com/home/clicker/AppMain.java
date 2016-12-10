package com.home.clicker;

import com.home.clicker.misc.PatchNotifier;
import com.home.clicker.ui.FileChooser;
import com.home.clicker.ui.WindowFrame;
import com.home.clicker.utils.CachedFilesUtils;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AppMain {
    public static void main(String[] args) {
        if(CachedFilesUtils.getGamePath().equals("")) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setVisible(true);
        }else {
            ExecutorService executor = Executors.newFixedThreadPool(4);
            executor.execute(() -> {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new WindowFrame();
                    }
                });
//                Application.launch(FXFrame.class);
            });
            executor.execute(PrivateMessageManager::new);
            executor.execute(PatchNotifier::new);

            //ебанутый кастыль //todo
        }
    }
}

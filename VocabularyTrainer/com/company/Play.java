package com.company;

import java.io.FileNotFoundException;

public class Play {

    public static void main(String[] args) throws FileNotFoundException {
        Trainer trainer = new Trainer();
        trainer.printRecordsAmount();
        trainer.trainerStart();
    }
}

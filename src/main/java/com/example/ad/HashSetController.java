package com.example.ad;

import com.example.ad.dataStructures.CustomBinaryTree;
import com.example.ad.dataStructures.CustomHashSet;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HashSetController<T> {
    @FXML
    private TextField newValue;
    @FXML
    private Label values, searchLabel;
    private CustomHashSet hashSet;


    public void initialize(){
        hashSet = new CustomHashSet();
    }

    public void updateLabel(){
    }

    public void clearSearchLabel(){
        searchLabel.setText("");
    }

    public void search(){
        clearSearchLabel();
    }

    public void reset(){
        updateLabel();
    }

    public void sort(){
        updateLabel();
    }

    public void addValue(){
        clearSearchLabel();
        if(newValue.getText().trim() == ""){
            return;
        }
        hashSet.add(newValue.getText());
        updateLabel();
        newValue.setText("");
    }
}

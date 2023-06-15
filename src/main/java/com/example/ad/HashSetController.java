package com.example.ad;

import com.example.ad.dataStructures.CustomBinaryTree;
import com.example.ad.dataStructures.CustomHashSet;
import com.example.ad.sorting.BubbleSort;
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
        clearValuesLabel();
        values.setText(hashSet.printHset());
    }

    public void clearValuesLabel(){
        values.setText("");
    }

    public void clearSearchLabel(){
        searchLabel.setText("");
    }

    public void search(){
        clearSearchLabel();

        boolean contains = hashSet.customLinearSearch(newValue.getText());

        if (contains){
            searchLabel.setText("Binary tree contains: " + newValue.getText());
        }else{
            searchLabel.setText("Binary tree does not contains: " + newValue.getText());

        }
    }

    public void reset(){
        updateLabel();
    }

    public void sort(){
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
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

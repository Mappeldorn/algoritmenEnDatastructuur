package com.example.ad;

import com.example.ad.dataStructures.CustomBinaryTree;
import com.example.ad.datasource.Car;
import com.example.ad.sorting.SelectionSort;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BinaryTreeController {
    @FXML
    private TextField newValue;
    @FXML
    private Label values, searchLabel;

    private CustomBinaryTree<String> binaryTree;


    public void initialize(){
        binaryTree = new CustomBinaryTree<>();
        Car audi = new Car("Audi", "rs3", 5, 360);
        Car mercedes = new Car("Mercedes", "c63 amg", 4,510);
        Car fiat = new Car("Fiat", "multipla", 4, 103);
//        binaryTree.insert(audi);

    }

    public void updateLabel(){
        values.setText(binaryTree.printTree());
    }

    public void clearSearchLabel(){
        searchLabel.setText("");
    }

    public void search(){
        clearSearchLabel();
        boolean contains = binaryTree.depthFirstSearch(newValue.getText());

        if (contains){
            searchLabel.setText("Binary tree contains: " + newValue.getText());
        }else{
            searchLabel.setText("Binary tree does not contains: " + newValue.getText());

        }
    }

    public void reset(){
        binaryTree = new CustomBinaryTree<String>();
        updateLabel();
    }

    public void sort(){
        SelectionSort ss = new SelectionSort();
        binaryTree.rebuild(ss.selectionSort(binaryTree.toList()));
        updateLabel();
    }

    public void addValue(){
        clearSearchLabel();
        if(newValue.getText().trim() == ""){
            return;
        }
        binaryTree.insert(newValue.getText().trim());
        updateLabel();
        newValue.setText("");
    }

}

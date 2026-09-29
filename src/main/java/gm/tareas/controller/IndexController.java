package gm.tareas.controller;

import gm.tareas.model.Task;
import gm.tareas.service.TaskService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.net.URL;
import java.util.ResourceBundle;


@Component
public class IndexController implements Initializable {

    @Autowired
    private TaskService taskService;

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task,Integer> idTaskColumn;

    @FXML
    private TableColumn<Task,String> nameColumn;

    @FXML
    private TableColumn<Task,String> inChargeColumn;

    @FXML
    private TableColumn<Task,String> statusColumn;

    private final ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    private TextField nameTaskText;

    @FXML
    private TextField inChargeText;

    @FXML
    private TextField statusText;

    private Integer idTaskIntern;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            taskTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            configureColumns();
            listTasks();
    }

    private void configureColumns(){
        idTaskColumn.setCellValueFactory(new PropertyValueFactory<>("idTask"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        inChargeColumn.setCellValueFactory(new PropertyValueFactory<>("inCharge"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void listTasks(){
        taskList.clear();
        taskList.addAll(taskService.listTasks());
        taskTable.setItems(taskList);
    }

    public void addTask(){

        if(idTaskIntern != null){
            showMessage("Error", "A task is currently selected. Edit it or use “Clean form” before adding a new one.");
            return;
        }
        if (nameTaskText.getText().isEmpty()){
            showMessage("Error", "You must write a task");
            nameTaskText.requestFocus();
            return;
        }else{
            var task = new Task();
            getDataForm(task);
            task.setIdTask(null);
            taskService.saveTask(task);
            showMessage("Information", "task added");
            clearForm();
            listTasks();
        }
    }

    public void showMessage(String tit, String msg){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle(tit);
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
    }

    public void getDataForm(Task task){
        if(idTaskIntern != null){
            task.setIdTask(idTaskIntern);
        }
        task.setName(nameTaskText.getText());
        task.setInCharge(inChargeText.getText());
        task.setStatus(statusText.getText());
    }

    public void clearForm(){
        idTaskIntern = null;
        nameTaskText.clear();
        inChargeText.clear();
        statusText.clear();
    }

    public void loadTaskForm(){
        var task = taskTable.getSelectionModel().getSelectedItem();
        if(task != null){
            idTaskIntern = task.getIdTask();
            nameTaskText.setText(task.getName());
            inChargeText.setText(task.getInCharge());
            statusText.setText(task.getStatus());
        }
    }

    public void modifyTask(){
        if(idTaskIntern == null){
            showMessage("Information", "You must select a task");
            return;
        }
        if(nameTaskText.getText().isEmpty()){
            showMessage("Validation","You must write a task");
            nameTaskText.requestFocus();
            return;
        }
        var task = new Task();
        getDataForm(task);
        taskService.saveTask(task);
        showMessage("Information", "Task modified");
        clearForm();
        listTasks();
    }

    public void deleteTask(){
        if(idTaskIntern == null){
            showMessage("Information", "You must select a task");
            return;
        }
        var task = new Task();
        getDataForm(task);
        taskService.deteleTask(task);
        showMessage("Information", "Task deleted");
        clearForm();
        listTasks();
    }
}

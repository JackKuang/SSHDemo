package com.hurenjieee.util;

import java.util.List;



/**
 * @Description: ���ڵ�
 * @Author: JackKuang
 * @Since: 2017��3��14������3:13:39  
 */
public class Node {
    private Long id;
    private String text;
    private List<Node> nodes;
    
    public String getText(){
        return text;
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public List<Node> getNodes(){
        return nodes;
    }
    
    public void setNodes(List<Node> nodes){
        this.nodes = nodes;
    }

    public Long getId(){
        return id;
    }

    
    public void setId(Long id){
        this.id = id;
    }
    
    
    
}

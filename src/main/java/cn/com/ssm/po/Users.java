package cn.com.ssm.po;

import java.util.ArrayList;
import java.util.List;

public class Users extends User {
    private List<Integer> idList = new ArrayList<Integer>();

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }
}

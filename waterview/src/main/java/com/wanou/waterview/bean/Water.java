package com.wanou.waterview.bean;

/**
 * 创建时间: 2018/1/9
 * 创建人:  赖天兵
 * 描述:
 */

public class Water {
    private String number;
    private String name;

    public Water(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Water water = (Water) o;

        if (!number.equals(water.number)) {
            return false;
        }
        return name.equals(water.name);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}

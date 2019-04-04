package com.wxiip.emun;

public enum Defect_enum {
    BLOCK_DEFECTS("block_defects","块状缺陷"),
    CRESCENT_MARK_DEFECTS("crescent_mark_defects","月牙形缺陷"),
    MARK_DEFECTS("mark_defects","标记"),
    SPOT_DEFECTS("spot_defects","斑点"),
    TRACE_DEFECTS("trace_defects","划痕");

    private String name;
    private String type;
    Defect_enum(String name,String type) {
        this.name = name;
        this.type = type;
    }


}

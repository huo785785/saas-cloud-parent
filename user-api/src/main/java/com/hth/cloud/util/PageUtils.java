package com.hth.cloud.util;

import com.github.pagehelper.Page;
import com.hth.cloud.common.util.PageVO;

import java.util.List;

/**
* @ClassName:       PageUtils
*                   分页工具类
* @Author:          huoth
* @CreateDate:      2019/1/18 15:55
* @UpdateUser:      huoth
* @UpdateDate:      2019/1/18 15:55
* @Version:         0.0.1
*/
public class PageUtils {
	private PageUtils() {}

    public static <T> PageVO<T> getPageVO(List<T> list) {
        PageVO<T> result = new PageVO<>();
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            result.setTotalRows(page.getTotal());
            result.setTotalPages(page.getPages());
            result.setPageNum(page.getPageNum());
            result.setPageSize(page.getPageSize());
            result.setCurPageSize(page.size());
            result.setList(page.getResult());
        }
        return result;
    }
}

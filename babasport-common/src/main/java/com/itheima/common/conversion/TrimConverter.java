package com.itheima.common.conversion;

import org.springframework.core.convert.converter.Converter;
/**
 * 自定义转换去掉前后空格
 * @author lx
 *
 */
public class TrimConverter implements Converter<String, String>{

	@Override
	public String convert(String source) {
		// TODO Auto-generated method stub
		try {
			if(null != source){
				source = source.trim();
				if(!"".equals(source)){
					return source;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}

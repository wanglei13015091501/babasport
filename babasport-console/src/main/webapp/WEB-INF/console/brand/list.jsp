<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.itheima.common.page.Pagination" %>
<%@ include file="../head.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>babasport-list</title>
<script type="text/javascript">
    $(function(){
        //全选
        $("#checkAll").click(function(){
            $("input[name='ids']").attr("checked",this.checked);
        })

        //批量删除
        $("#batchDel").click(function(){
            var size = $("input[name='ids']:checked").size();
            if(size==0){
                alert("请至少选择一个");
                return;
            }
            if(!confirm("你确定删除吗?")){
                return;
            }
            var ids = new Array();
            $("input[name='ids']:checked").each(function(){
                ids.push($(this).val());
            })
			var name = $("#name").val();
		    var isDisplay = $("#isDisplay").val();
		    var pageNo = "${pagination.pageNo}"
		    location.href = "${ctx}/brand/batchDelete.do?ids="+ids+"&name="+name+"&isDisplay="+isDisplay+"&pageNo="+pageNo;
        })

    })
</script>
</head>
<body>
<div class="box-positon">
	<div class="rpos">当前位置: 品牌管理 - 列表</div>
	<form class="ropt">
		<input class="add" type="button" value="添加" onclick="javascript:window.location.href='add.jsp'"/>
	</form>
	<div class="clear"></div>
</div>
<div class="body-box">
<form action="/brand/list.do" method="post" style="padding-top:5px;">
品牌名称: <input id="name" type="text" name="name" value="${name}"/>
	<select id="isDisplay" name="isDisplay">
		<option value="1" <c:if test="${isDisplay == 1 }">selected="selected"</c:if>>是</option>
		<option value="0" <c:if test="${isDisplay == 0 }">selected="selected"</c:if>>否</option>
	</select>
	<input type="submit" class="query" value="查询"/>
</form>
<table cellspacing="1" cellpadding="0" border="0" width="100%" class="pn-ltable">
	<thead class="pn-lthead">
		<tr>
			<th width="20"><input id="checkAll" type="checkbox"/></th>
			<th>品牌ID</th>
			<th>品牌名称</th>
			<th>品牌图片</th>
			<th>品牌描述</th>
			<th>排序</th>
			<th>是否可用</th>
			<th>操作选项</th>
		</tr>
	</thead>
	<tbody class="pn-ltbody">
	<c:forEach items="${pagination.list }" var="brand">
		<tr bgcolor="#ffffff" onmouseout="this.bgColor='#ffffff'" onmouseover="this.bgColor='#eeeeee'">
			<td align="center"><input type="checkbox" value="${brand.id }" name="ids"/></td>
			<td align="center">${brand.id }</td>
			<td align="center">${brand.name }</td>
			<td align="center"><img width="40" height="40" src="${brand.imgUrl }"/></td>
			<td align="center"></td>
			<td align="center">99</td>
			<td align="center">
				<c:if test="${brand.isDisplay == 1 }">是</c:if>
				<c:if test="${brand.isDisplay == 0 }">否</c:if>
			</td>
			<td align="center">
			<a class="pn-opt" href="/brand/toEdit.do?id=${brand.id }">修改</a> | <a class="pn-opt" onclick="if(!confirm('您确定删除吗？')) {return false;}" href="#">删除</a>
			</td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>
<div class="page pb15">
	<span class="r inb_a page_b">
		<c:forEach items="${pagination.pageView }" var="page">
			${page }
		</c:forEach>
	</span>
</div>
<div style="margin-top:15px;"><input id="batchDel" class="del-button" type="button" value="删除" /></div>
</div>
</body>
</html>
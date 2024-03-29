<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.edoc.utils.*;"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<% 
	String fileName = (String)request.getAttribute("fileName");
	
	String filePath = basePath + "temp/" + fileName+"_#_DISPLAYFILENAME";
	Md5Double des = new Md5Double();    
    filePath = des.encrypt(filePath);
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <base target="_self">
    <title>查看原文</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  	<script type="text/javascript" src="js/office_edit.js"></script>
  	<script type="text/javascript" src="js/jquery.min.js"></script>
  	<style type="text/css">
			.office_edit {
				position:relative;
				margin:0 auto;
				width:100%;
				height:660;
				border:1px solid #7fa9e4;
				z-index:1;
			}
			
			.office_edit_tools {
				position:relative;
				left:1%;
				top:5px;
				width:98%;
				height:24px;
				z-index:1;
				background:url(images/office_edit_tools_bg.gif) repeat;
				border:1px solid #99bbe8;
				float:left;
				line-height:24px;
			}
			
			.office_edit_doc {
				position:relative;
				left:1%;
				top:10px;
				width:98%;
				height:600;
				z-index:1;
				border:1px solid #99bbe8;
				float:left;
			}
			.offiec_button{
				position:relative;
			    border:0 none;
			    background:transparent;
			    padding-left:10px;
			    padding-right:10px;
			    overflow:visible;
			    width:auto;
			    -moz-outline:0 none;
			    outline:0 none;
				border:1px solid #7fa9e4;
			}
			.STYLE1 {
				font-size: 12px;
				font-weight: bold;
				font-family: "宋体";
			}
	</style>
	<script type="text/javascript">
		function ShowActiveX(){
			try{
				document.getElementById("afrmxCommonFileView1").SetTransportMode(2);
				document.getElementById("afrmxCommonFileView1").SetEncrypt(1);
				document.getElementById("afrmxCommonFileView1").SetCanPrint(0);
				document.getElementById("afrmxCommonFileView1").SetCanDownload(0);
				document.getElementById("afrmxCommonFileView1").SetDisablePrtScrn(1);
				document.getElementById("afrmxCommonFileView1").SetTransportPath("<%=filePath %>");
				document.getElementById("afrmxCommonFileView1").ShowFile();		
			}catch(err){
				alert('系统检测到您电脑中未安装系统插件，请下载安装');
				document.form1.submit();
			}
		}
	</script>
  </head>
  
  <body  onload = "javascript: ShowActiveX();">
  	<form name="form1"  target="_blank"  action="sfile/DocView.exe" method="post">
	</form>
	<form id="previewFileForm" action="" method="post">
		<input type="hidden" name="sourceFileId" value="${fileVersion.edocFileId }" />
		<input type="hidden" name="version" value="${fileVersion.version }" />
	</form>
	 <div class="office_edit">
  <div class="office_edit_tools">
  	<div style="position: relative;vertical-align: middle;display: table-cell;float:left;padding-left:10px;">
		<span class="STYLE1">当前文件:</span>	<span style="font-size: 12px;font-family: "宋体";">${fileVersion.fileName }</span>
	</div>
  	<div style="position: relative;top: 10%;vertical-align: middle;display: table-cell;float:right;padding-right:10px;">
	<input type="button" class="offiec_button" onclick="before_edit_office('${fileVersion.edocFileId }','${DOCUSER.id }','${fileVersion.fileSuffix }')" value="编辑" />
	<input type="button" class="offiec_button" onclick="exit()" value="退出" />
	</div>
  </div>
  <div class="office_edit_doc">
  	<OBJECT id="afrmxCommonFileView1"
		classid="clsid:5858AFC0-2EF5-45AA-B891-CE604CF228B7"
		type="application/x-oleobject"
		align="baseline" border="0"
		codebase="<%=request.getContextPath()%>/back/uploadfile/PDEReader.rar"
		WIDTH="100%" height="610">      
    </OBJECT>
  </div>
</div>
  </body>
</html>

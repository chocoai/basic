<script src="${_share_file_url!''}/resource/js/jquery.uploadfile.js" type="text/javascript"></script>
<link href="${_share_file_url!''}/resource/css/uploadfile.css" rel="stylesheet" type="text/css" / >
<script language="javascript">
var uploadObj;
$(document).ready(function()
{
	var uploadObj=$("#but1").uploadFile({
		url:"${_server_url!''}/portal/commonservice.multi.uploadimage",
		formData:{savepath:'boy/', id: '',urlPath:''},//存放文件的路径及其他上传需要的参数
		multiple:true,
		returnType: 'json',
		allowedTypes: "jpg,png,gif",//接受的文件类型
		acceptFiles: "jpg,png,gif",//接受的文件类型
		autoSubmit: false,//是否自动提交
		fileName:"myfile[]",//上传域的名字
		shwCancel: false,
        showAbort: false,
        showDone: false,
        showDelete: true,
        statusBarWidth: 400,
        dragdropWidth: 100,//上传按钮的宽度
        showPreview: true,//是否显示预览图片
        previewHeight: "100",//预览图片的宽度
        previewWidth: "150",
        uploadFolder:"",//文件路径，我们系统中用空就可以
        uploadButtonClass:"ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only",//上传按钮的样式
		onSuccess:function(files,data,xhr,pd)
		{
			//files: list of files
			//data: response from server
			//xhr : jquer xhr object
			if(typeof(data.image_id) != 'undefined')
			{
				//alert("上传成功！"+data.image_id+"...simage_url="+data.simage_url);
				pd.statusbar.hide();
				pd.del.click();
				var str=$("#imgs").val();
				if(str=="")
					str=data.image_id;
				else
					str=str+","+data.image_id;
				$("#imgs").val(str);
				uploadObj.createProgress(data.simage_url);
			}
		},
		deleteCallback: function(data,pd)
		{
			for(var i=0;i<data.length;i++)
			{
			 	$.post("${_server_url!''}/portal/commonservice.anneximage.delete",
				 	{"simageurl":data[i]},
				    function(resp, textStatus, jqXHR)
				    {
						var jdata=jQuery.parseJSON(resp);  
						var str=$("#imgs").val();
						if(str==jdata.image_id)
							str="";
						else{
							str=str.replace(jdata.image_id+",","");
							str=str.replace(","+jdata.image_id,"");
						}
						$("#imgs").val(str);
						alert("删除成功");	    
				    });
			 }		
			pd.statusbar.hide(); //You choice to hide/not.
		
		},
		onLoad:function(obj)
	    {
	        $.ajax({
	            cache: false,
	            url: "${_server_url!''}/portal/safecheck.image.list",
	            dataType: "json",
	            success: function(data) 
	            {
	            	var str="";
	            	for(var i=0;i<data.images.length;i++)
	                {	
	                	obj.createProgress(data.images[i]);
	                	if(i==0)
	                		str=data.ids[i];
	                	else
	                		str=str+","+data.ids[i];
	                }
	                $("#imgs").val(str);
	            }
	        });
   		}
	});
	$("#abc").click(function(){
		uploadObj.startUpload();
	});
	$("#queding").click(function(){
		alert($("#imgs").val());
		//window.returnValue=$("#imgs").val();
		//window.close();
	});	
	$("#quxiao").click(function(){
		//应该调用一个函数把新增的图片删掉才行
		window.close();
	});
});
</script>
<input type="hidden" id="imgs" size="400">
<button id="abc" type="button">上传</button>
<button id="queding" type="button">确定</button>
<button id="quxiao" type="button">取消</button>
<button id="but1" type="button">选择</button>


<!--input type="file" name="file[]" multiple="multiple" /-->

<form method="post" action="upload-page.php" enctype="multipart/form-data">
  <input name="filesToUpload[]" id="filesToUpload" type="file" multiple="" />
</form>


<p>jquery uploadify FLASH 上传插件</p>
<!--uploadify-->
<script src="${_share_file_url!''}/resource/jsp/jquery.uploadify.js"></script>
<link href="${_share_file_url!''}/resource/jsp/uploadify.css" rel="stylesheet">
	<script language="javascript">
	$(function() {
	    $("#file_upload_1").uploadify({
	        height        : 30,
	        swf           : '${_share_file_url!''}/resource/jsp/uploadify.swf',
	        uploader      : '${_server_url!''}/portal/commonservice.multi.uploadimage',
	        folder 	      : 'boy/',
	        multi :true,
	        fileTypeDesc: 'Bild JPG',
	        fileExt :'*.jpg;*.png;*.gif',
	        buttonText:'选择文件',
	        width         : 120,
	        removeCompleted : false,
	        postData: {savepath:'boy/', id: '',urlPath:''}//和后台交互时，附加的参数
	        
	    });
	});
	</script>
	<p><input type="file" name="file_upload_1" id="file_upload_1" multiple="true"/></p>
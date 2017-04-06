<script type="text/javascript" src="${_share_file_url!''}/resource/js/jquery.form.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${_share_file_url!''}/resource/js/ajaxfileupload.js"></script>
<script type="text/javascript" language="javascript">
$(function(){
	$("#jd_date").attr("readonly", "true").datepicker({dateFormat:"yy-mm-dd"});
});
function dosave(op){
	var str="";
	if(null==$("#building_address").val() || $("#building_address").val()==''){
		str+="鉴定地址不能为空\n\r";
	}
	if(null==$("#building_region").val() || $("#building_region").val()==''){
		str+="所属区域不能为空\n\r";
	}
	if(null==$("#jdmember").val() || $("#jdmember").val()==''){
		str+="鉴定人不能为空\n\r";
	}
	var jd_date=$("#jd_date").val();
	if(jd_date!=""){
		var ed=new Date();
		re = /-/g;
		var sd=new Date(Date.parse(jd_date.replace(re, "/")));
		if(sd>ed){
			str+="鉴定日期不能大于当前日期\n\r";
		}
	}else{
		str+="鉴定日期不能为空\n\r";
	}
	var level=$("[name=dangerous_level]:checked").val();
	if(level==undefined)
		str+="房屋危险等级不能为空\n\r";
	//if(null==$("#jd_report").val() || $("#jd_report").val()==''){
	//	str+="鉴定报告附件不能为空\n\r";
	//}
	if(str!=''){
		alert(str);
	}else{	
		var queryString=$("#addForm").formSerialize();
		$.post($("#addForm").attr("action")+"?op="+op,queryString,
			function(data,textStatus){
			var jdata=jQuery.parseJSON(data);
			if(jdata.success==0){
				if(op=="zc")
					alert("暂存失败！");
				else
					alert("提交失败！");
			}else{
				if(op=="zc")
					alert("暂存成功！");
				else
					alert("提交成功！");	
				window.close();			
			}
		});
	}
}
function imageUpload()
	{
		if($("#fileToUpload").val()==''||$("#fileToUpload").val()==null){
			alert("请先选择要上传的文件！");
			return false;
		}else{
			$.ajaxFileUpload
		(
			{
				url:'${_server_url!''}/eap/safecheck.uploadimage',
				secureuri:false,
				fileElementId:'fileToUpload',
				dataType: 'json',
				data:{savepath:'files/survey/'},
				success: function (data, status)
				{
					if(typeof(data.returnfilename) != 'undefined')
					{
						if(data.returnfilename != '')
						{
							alert("上传成功！");
							$("#jd_image").val(data.returnfilename);
							$("#jd_image1").val(data.returnfilename);
							//$("#returnval").attr("href",data.returnfilename);
							//$("#returnval").text("点击查看");
							$("#returnval").attr("style","display:inline-block");
						}else
						{
							alert("未上传成功！");
						}
					}
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		)
		
		return false;
			
		}
		
	}
function fileUpload()
	{
		if($("#fileToUpload1").val()==''||$("#fileToUpload1").val()==null){
			alert("请先选择要上传的文件！");
			return false;
		}else{
			$.ajaxFileUpload
		(
			{
				url:'${_server_url!''}/eap/safecheck.uploadfile',
				secureuri:false,
				fileElementId:'fileToUpload1',
				dataType: 'json',
				data:{savepath:'files/survey/'},
				success: function (data, status)
				{
					if(data.success=='0'){
						alert("上传成功！");
						$("#jd_report").val("/eap/commonservice.download?file_id="+data.file_id);
						$("#jd_report1").val("/eap/commonservice.download?file_id="+data.file_id);
						//$("#jd_report").val(data.save_name);
						//$("#returnval1").attr("href",data.save_name);
						//$("#returnval1").text("点击下载");
						$("#returnval1").attr("style","display:inline-block");
					}else if(data.success=='1'){
						alert("请检查上传文件的类型！");
					}else{
						alert("没有上传权限！");
					}
				},
				error: function (data, status, e)
				{
					alert(e);
				}
			}
		)
		
		return false;
			
		}
		
	}
function fileDownload(){
	window.location.href=$("#jd_report").val();
}
function imageDownload(){
	window.open($("#jd_image").val(),'_blank','depended=yes,top='+(window.screen.height-30-500)/2+',left='+(window.screen.width-10-800)/2+',width=800,height=500,menubar=no,toolbar=no,location=no,directories=no,status=no,scrollbars=yes');
}
</script>
<style>
.td12{text-align:right;padding-right:12px;background-color:#E1F1FE;color:#2a51a4;}
.td13{padding-left:12px;background-color:#F1F8FF;color:#4D4D4D;}
.tdpad {padding-left:4px; background-color:#ffffff}
.td_title {text-align:right;padding-right:4px; background-color:#ffffff}
.file-box input{ vertical-align:middle; margin:0; padding:0}
.file-box{ position:relative;width:440px;WHITE-SPACE:nowrap;}
.file-box .txt{ height:22px; border:1px solid #cdcdcd; width:195px;}
.file-box .btn{ background-color:#FFF; border:1px solid #CDCDCD;height:24px; width:60px;}
.file-box .file{ position:absolute; top:3px; right:180px; height:24px; filter:alpha(opacity:0);opacity: 0;width:260px }
</style>
<div class="widget-title-normal">
	<div class="child">
		<span class="widget-title-text">
			鉴定报告增加
		</span>
	</div>
</div>
<form action="${_servlet_url!''}/safeauth.report.insert" id="addForm" method="post">
	<input type="hidden" name="building_id" value="${block.sbid!''}">
	<div  id="buttons" style="text-align:right">
		<button type="reset">重置</button>
		<button type="button" onclick="dosave('zc');">暂存</button>
		<button type="button" onclick="dosave('tj');">提交</button>
	</div>
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#dee2e3" style="line-height:30px;">
		<tr>
			<td class="td12"><font color="red">*&nbsp;</font>鉴定地址：</td>
			<td class="td13" colspan="3"><input type="text" name="building_address" id="building_address" size="60" value="${block.building_address!''}"></td>
			<td class="td12"><font color="red">*&nbsp;</font>所属区域：</td>
			<td class="td13">
				<select id="building_region" name="building_region">
					<option value="">------请选择------</option>
					[#list EnumService.getEnum('xzqh') as enum]
					<option value="${enum.enum_value!''}">${enum.enum_name!''}</option>
					[/#list]
				</select>
			</td>
		</tr>
		<tr>
			<td class="td12">委托人（单位）：</td>
			<td class="td13"><input type="text" name="entrust_user"></td>
			<td class="td12">联系人：</td>
			<td class="td13"><input type="text" name="linkman"></td>
			<td class="td12">联系电话：</td>
			<td class="td13"><input type="text" name="linktel"></td>			
		</tr>
		<tr>
			<td class="td12">鉴定单位：</td>
			<td class="td13">
				<input type="hidden" name="jd_department_id" id="jd_department_id" value="${user.organ!''}">
				<input type="text" name="jd_department" value="${user.organ_name!''}" readonly="true">
			</td>	
			<td class="td12"><font color="red">*&nbsp;</font>鉴定人：</td>
			<td class="td13"><input type="text" name="jdmember" id="jdmember" value="${user.fullname!''}"></td>
			<td class="td12"><font color="red">*&nbsp;</font>鉴定时间：</td>
			<td class="td13"><input type="text" name="jd_date" id="jd_date" value="${block.currentdate!''}"></td>
		</tr>
		<tr>
			<td class="td12"><font color="red">*&nbsp;</font>房屋危险等级：</td>
			<td class="td13">
				<input type="radio" name="dangerous_level" value="1">A级
				<input type="radio" name="dangerous_level" value="2">B级
				<input type="radio" name="dangerous_level" value="3">C级
				<input type="radio" name="dangerous_level" value="4">D级
			</td>
			<td class="td12">房屋结构老化程度：</td>
			<td class="td13">
				<input type="radio" name="struct_aging" value="1">强
				<input type="radio" name="struct_aging" value="2">弱
				<input type="radio" name="struct_aging" value="3">差
			</td>
			<td class="td12">是否有改造：</td>
			<td class="td13">
				<input type="radio" name="is_transform" value="1">是
				<input type="radio" name="is_transform" value="2">否
			</td>			
		</tr>
		<tr>
			<td class="td12">设施老化程度：</td>
			<td class="td13">
				<input type="radio" name="facility_aging" value="1">强
				<input type="radio" name="facility_aging" value="2">弱
				<input type="radio" name="facility_aging" value="3">差
			</td>
			<td class="td12">抗震结构是否完善：</td>
			<td class="td13">
				<input type="radio" name="is_kzperfect" value="1">强
				<input type="radio" name="is_kzperfect" value="2">弱
				<input type="radio" name="is_kzperfect" value="3">差
			</td>
			<td class="td12">拆改结构是否严重：</td>
			<td class="td13">
				<input type="radio" name="is_transform_seriousness" value="1">强
				<input type="radio" name="is_transform_seriousness" value="2">弱
				<input type="radio" name="is_transform_seriousness" value="3">差
			</td>			
		</tr>
		<tr>
			<td class="td12"><font color="red">&nbsp;</font>鉴定报告附件：</td>
			<td class="td13" colspan="5">
			<div class="file-box">
				<input type="hidden" name="jd_report" id="jd_report" class='txt' value="">
				<input type="text" name="jd_report1" id="jd_report1" class='txt' value="">
				<input type='button' class="btn" value='浏览...' />
				<input id="fileToUpload1" type="file" size="28" name="fileToUpload1" class="file" onchange="document.getElementById('jd_report1').value=this.value" >
				<input type='button' onclick="return fileUpload();" class="btn" value='点击上传' />
				<input type='button' onclick="fileDownload()" id="returnval1" name="returnval1"  class="btn"  style="margin-left:5px;display:none;" value="报告下载"/>
			</div>
			</td>
		</tr>
		<tr>
			<td class="td12">鉴定相关图片：</td>
			<td class="td13" colspan="5">
			<div class="file-box">
				<input type="hidden" name="jd_image" id="jd_image" class='txt' value="">
				<input type="text" name="jd_image1" id="jd_image1" class='txt' value="">
				<input type='button' class="btn" value='浏览...' />
				<input id="fileToUpload" type="file" size="28" name="fileToUpload" class="file" onchange="document.getElementById('jd_image1').value=this.value" >
				<input type='button' onclick="return imageUpload();" class="btn" value='点击上传' />
				<input type='button' onclick="imageDownload()"  class="btn"  id="returnval" name="returnval" style="margin-left:5px;display:none;" value="查看图片"/>
			</div>
			
			</td>
		</tr>
		<tr>
			<td class="td12">房屋概况：</td>
			<td class="td13" colspan="5">
			<textarea cols="100" rows="5" name="jz_overview"></textarea>
			</td>
		</tr>
		<tr>
			<td class="td12">鉴定结论：</td>
			<td class="td13" colspan="5">
			<textarea cols="100" rows="5" name="identify_conclusion"></textarea>
			</td>
		</tr>
		<!-- tr>
			<td class="td12">鉴定内容：</td>
			<td class="td13" colspan="5">
			<textarea cols="100" rows="5" name="identify_content"></textarea>
			</td>
		</tr-->		
	</table>
</form>

<style>
.middle{
	width:1000px;
	background-color:#fff;
	margin:0 auto;
	overflow:auto;
	padding-top:15px;
	margin-bottom:15px;
	}
.fcqd_image{
	padding:20px 0 30px 0;
	text-align:center;
	}
.fcqd_search{
	margin:0 auto;
	width:883px;
	height:110px;
	background:url(${_share_file_url!''}/resource/images/search_bj.png) no-repeat;
	margin-bottom:30px;}
.fcqd_search_content{
	float:left;
	padding-left:65px;
	padding-top:35px;}
.search_content_input{
	width:640px;
	height:40px;
	line-height:40px;
	font-family:"微软雅黑";
	font-size:14px;
	color:#4d4d4d;
	padding-left:15px;
	background:url(${_share_file_url!''}/gis/resource/images/search_input.jpg) no-repeat;
	border:none;
	}
.search_content_button{
	width:128px;
	height:40px;
	background:url(${_share_file_url!''}/gis/resource/images/qdsearch_button.jpg) no-repeat;
	border:none;
	cursor: pointer;}
.fcqd_search_content1{
	float:left;
	padding-left:20px;
	padding-top:35px;}
</style>

<div class="middle">
	<div class="fcqd_image"><img src="${_share_file_url!''}/gis/resource/images/fcqd_logo.jpg" width="206" height="46" />    	
	</div>
    <div class="fcqd_search">
    	<form action="${_servlet_url!''}/datacenter.qdserch" method="post">
    	<div >
        	<div class="fcqd_search_content"><input type="text" name="keyword" class="search_content_input" value=""/>
            </div>
            <div class="fcqd_search_content1"><input type="submit" name="button"  class="search_content_button" value="" />
            </div>
        </div>
        </form>
    </div>
</div>
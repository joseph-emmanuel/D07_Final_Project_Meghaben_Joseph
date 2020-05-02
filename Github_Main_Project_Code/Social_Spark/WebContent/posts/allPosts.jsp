<form action="PostOperation" method="post">
<span>${param.date}</span> <br>
<input type="text" value="${param.content}" name ="content">
<input type="hidden" name="id" value="${param.id}"/>
<span>${param.like}</span><br>
	<button type="submit" name="like" value="${param.id} ">Like</button>
	<button type="submit" name="save" value="${param.id} ">Save</button>
	<button type="submit" name="unlike" value="${param.id} ">Unlike</button>
	
</form>

 <br><br><br>

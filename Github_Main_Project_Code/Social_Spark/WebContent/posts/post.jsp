


<form action="PostOperation" method="post">
<span>${param.date}</span> <br>
<input type="text" value="${param.content}" name ="content">
<input type="hidden" name="id" value="${param.id}"/>
	<button type="submit" name="delete" value="${param.id} ">Delete</button>
	<button type="submit" name="edit" value="${param.id} ">Edit</button>
</form>

 <br><br><br>

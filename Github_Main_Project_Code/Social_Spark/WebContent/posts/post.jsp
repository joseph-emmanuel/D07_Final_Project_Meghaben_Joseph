


<form action="PostOperation" method="post">
<span>${param.date}</span> <br>
<input type="text" value="${param.content}" name ="c">
<span>${param.email}</span><br>
	<button type="submit" name="delete" value="${param.id} ">Delete</button>
	<button type="submit" name="edit" value="${param.id} ">Edit</button>
	<button type="submit" name="like" value="${param.id} ">Like</button>
	<button type="submit" name="unlike" value="${param.id} ">Unlike</button>

</form>

 <br><br><br>

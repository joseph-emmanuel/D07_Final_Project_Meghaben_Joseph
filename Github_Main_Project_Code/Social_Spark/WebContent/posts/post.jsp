
<span>${param.date}</span> <br>
<span>${param.content}</span> <br>
<span>${param.email}</span><br>

<form action="PostOperation" method="post">

	<button type="submit" name="delete" value="${param.id} ">Delete</button>
	<button type="submit" name="edit" value="${param.id} ">Edit</button>
	<button type="submit" name="like" value="${param.id} ">Like</button>

</form>

 <br><br><br>

var formPost = document.getElementById("create-post-form");


if (formPost.addEventListener) {                   
    formPost.addEventListener("submit", validatePost);
} else if (formPost.attachEvent) {                  
    formPost.attachEvent("onsubmit", validatePost);
}

function validatePost(evt){
	var title = document.getElementById('creating-post-title');
	var post_content = document.getElementById('creating-post-content');
	var countErr = 0;

	/* Validação do campo título */
	title_box = document.querySelector('.msg-title');
	if(title.value == ""){
		title_box.innerHTML = "O título não pode ser vazio";
		title_box.style.display = 'block';
		countErr += 1;
	}else{
		title_box.style.display = 'none';
    }
    
    /* Validação do corpo do artigo */
	content_box = document.querySelector('.msg-content');
	if(post_content.value == ""){
		content_box.innerHTML = "O artigo não pode ser vazio!";
		content_box.style.display = 'block';
		countErr += 1;
	}else{
		content_box.style.display = 'none';
	}
	
    if(countErr > 0){
		evt.preventDefault();
	}
}
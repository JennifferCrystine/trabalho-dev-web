var formLogin = document.getElementById("form-login");
var formSignUp = document.getElementById("form-signup");


if (formLogin.addEventListener) {                   
    formLogin.addEventListener("submit", validateLogin);
} else if (formLogin.attachEvent) {                  
    formLogin.attachEvent("onsubmit", validateLogin);
}

if (formSignUp.addEventListener) {                   
    formSignUp.addEventListener("submit", validateSignUp);
} else if (formSignUp.attachEvent) {                  
    formSignUp.attachEvent("onsubmit", validateSignUp);
}

function validateLogin(evt){
	var cpf = document.getElementById('user-cpf');
	var password = document.getElementById('user-password');
	var countErr = 0;

	/* Validação do campo nome */
	cpf_box = document.querySelector('.msg-cpf');
	if(cpf.value == ""){
		cpf_box.innerHTML = "Por favor, forneça seu CPF!";
		cpf_box.style.display = 'block';
		countErr += 1;
	}else{
		cpf_box.style.display = 'none';
	}
	
	/* Validação do campo senha */
	password_box = document.querySelector('.msg-password');
	if(password.value == ""){
		password_box.innerHTML = "Por favor, forneça sua senha!";
		password_box.style.display = 'block';
		countErr += 1;
	}else if(password.value.length < 6){
		password_box.innerHTML = "Favor preencher a Senha com o mínimo de 6 caracteres";
		password_box.style.display = 'block';
		countErr += 1;
	}else{
		password_box.style.display = 'none';
    }	
    if(countErr > 0){
		evt.preventDefault();
	}
}

function validateSignUp(evt){
	var name = document.getElementById('user-name');
	var mail = document.getElementById('user-email');
	var cpf = document.getElementById('user-cpf-signup');
	var password = document.getElementById('user-password');
	var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	var countErr = 0;


	/* Validação do campo nome */
	name_box = document.querySelector('.msg-name');
	if(name.value == ""){
		name_box.innerHTML = "Forneça seu nome!";
		name_box.style.display = 'block';
		countErr += 1;
	}else{
		name_box.style.display = 'none';
	}

	/* Validação do campo email */
	mail_box = document.querySelector('.msg-email');
	if(mail.value == ""){
		mail_box.innerHTML = "Favor preencher o E-mail";
		mail_box.style.display = 'block';
		countErr += 1;
	}else if(filtro.test(mail.value)){
		mail_box.style.display = 'none';
	}else{
		mail_box.innerHTML = "Formato do E-mail inválido";
		mail_box.style.display = 'block';
		countErr += 1;
	}	

	/* Validação do campo cpf */
	cpf_box = document.querySelector('.msg-cpf-signup');
	if(cpf.value == ""){
		cpf_box.innerHTML = "Favor preencher o CPF";
		cpf_box.style.display = 'block';
		countErr += 1;
	}else{
		cpf_box.style.display = 'none';
	}

	/* Validação do campo senha */
	password_box = document.querySelector('.msg-password-signup');
	if(password.value == ""){
		password_box.innerHTML = "Favor preencher a Senha";
		password_box.style.display = 'block';
		countErr += 1;
	}else if(password.value.length < 6){
		password_box.innerHTML = "Favor preencher a Senha com o mínimo de 6 caracteres";
		password_box.style.display = 'block';
		countErr += 1;
	}else{
		password_box.style.display = 'none';
	}

	if(countErr > 0){
		evt.preventDefault();
	}
}


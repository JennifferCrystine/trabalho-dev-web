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
	var cpf = document.getElementById('user-cpf-login');
	var password = document.getElementById('user-password-login');
	var countErr = 0;

	/* Validação do campo nome */
	cpf_box = document.querySelector('msg-erro msg-password-login');
	if(cpf.value === ""){
		cpf_box.innerHTML = "Seu CPF não pode ser vazio!";
		cpf_box.style.display = 'block';
		countErr += 1;
	}else{
		cpf_box.style.display = 'none';
	}
	
	/* Validação do campo senha */
	password_box = document.querySelector('.msg-erro msg-password');
	if(password.value === ""){
		password_box.innerHTML = "Sua senha não pode ser vazia!";
		password_box.style.display = 'block';
		countErr += 1;
	}else if(password.value.length < 6){
		password_box.innerHTML = "Sua senha deve ter no mínimo 6 caracteres";
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
	var password = document.getElementById('user-password-signup');
	var countErr = 0;
	var numbers = /^[0-9]+$/;


	/* Validação do campo nome */
	name_box = document.querySelector('.msg-erro msg-name');
	if(name.value === ""){
		name_box.innerHTML = "Você precisa nos dizer seu nome!";
		name_box.style.display = 'block';
		countErr += 1;
	}else{
		name_box.style.display = 'none';
	}

	/* Validação do campo email */
	mail_box = document.querySelector('.msg-erro msg-email');
	if(mail.value === ""){
		mail_box.innerHTML = "Seu email não pode ser vazio!";
		mail_box.style.display = 'block';
		countErr += 1;
	}else if(filtro.test(mail.value)){
		mail_box.style.display = 'none';
	}else{
		mail_box.innerHTML = "O formato do seu email é inválido";
		mail_box.style.display = 'block';
		countErr += 1;
	}	

	/* Validação do campo cpf */
	cpf_box = document.querySelector('.msg-erro msg-cpf-signup');	
	if(cpf.value === ""){
		cpf_box.innerHTML = "CPF não pode ser vazio";
		cpf_box.style.display = 'block';
		countErr += 1;
	}
	else if(!cpf.value.match(numbers)) {
		cpf_box.innerHTML = "CPF deve conter apenas números!";
		cpf_box.style.display = 'block';
		countErr += 1;
	}
	else{
		cpf_box.style.display = 'none';
	}

	/* Validação do campo senha */
	password_box = document.querySelector('.msg-erro msg-password-signup');
	if(password.value === ""){
		password_box.innerHTML = "A senha não pode ser vazia!";
		password_box.style.display = 'block';		
		countErr += 1;
	}else if(password.value.length < 6){
		password_box.innerHTML = "A senha deve ter no mínimo 6 caracteres!";
		password_box.style.display = 'block';
		countErr += 1;
	}else{
		password_box.style.display = 'none';
	}
	if(countErr > 0){
		evt.preventDefault();
	}
}
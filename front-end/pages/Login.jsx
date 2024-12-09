import { useForm } from "react-hook-form";
import { FaInfoCircle, FaCheckCircle, FaTimes } from "react-icons/fa";
import axios from 'axios';

function Login() {
  const URL_API = 'http://localhost:3000/api/auth';
  const { register, handleSubmit, formState: { errors }, setError } = useForm();

  const onSubmit = async (data) => {
    try {
      const resposta = await axios.post(`${URL_API}/login`, {
        username: data.username,
        password: data.password,
        // Você pode adicionar outros dados aqui conforme necessário, como crm ou coren
      });

      // Armazena token no localStorage
      localStorage.setItem('token', resposta.data.token);
      
      // Define cabeçalho padrão para futuras requisições
      axios.defaults.headers.common['Authorization'] = `Bearer ${resposta.data.token}`;

      // Redireciona ou atualiza estado do app
      console.log('Login bem-sucedido!');
    } catch (err) {
      console.error('Falha no login');
    }
  };

  return (
    <div className="container">
      <h1>Registrar</h1>
      <form onSubmit={handleSubmit(onSubmit)} method="post">
        
        <label htmlFor="username">
          Nome de Usuário:
          {errors.username ? <FaTimes /> : <FaCheckCircle />}
        </label>
        <input
          type="text"
          id="username"
          {...register("username", { required: "Nome de usuário é obrigatório", maxLength: 11 })}
        />
        {errors.username && (
          <p className="instructions">
            <FaInfoCircle /> {errors.username.message || "Nome de usuário inválido"}
          </p>)}
        
        <label htmlFor="password">
          Senha:
          {errors.password ? <FaTimes /> : <FaCheckCircle />}
        </label>
        <input
          type="password"
          id="password"
          {...register("password", {
            required: "Senha é obrigatória",
            minLength: { value: 8, message: "A senha deve ter no mínimo 8 caracteres" },
            maxLength: { value: 24, message: "A senha deve ter no máximo 24 caracteres" }
          })}
        />
        {errors.password && (
          <p className="instructions">
            <FaInfoCircle /> {errors.password.message || "Senha inválida"}
          </p>
        )}
        
        <label htmlFor="confirm_pwd">
          Confirmar Senha:
          {errors.confirm_pwd ? <FaTimes /> : <FaCheckCircle />}
        </label>
        <input
          type="password"
          id="confirm_pwd"
          {...register("confirm_pwd", {
            required: "Confirmação de senha é obrigatória",
            validate: value => value === watch("password") || "As senhas não coincidem"
          })}
        />
        {errors.confirm_pwd && (
          <p className="instructions">
            <FaInfoCircle /> {errors.confirm_pwd.message || "As senhas não coincidem"}
          </p>
        )}

        <button type="submit" onClick={() => handleSubmit(onSubmit())}>Cadastrar</button>
      </form>
    </div>
  );
 }

export default Login;
        
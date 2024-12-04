import React, { useRef, useState, useEffect } from "react";
import { FaInfoCircle } from "react-icons/fa";
import { FaUser } from "react-icons/fa";
import axios from 'axios';

function Login() {
  const USER_REGEX = /^\d{11}$/;

  const [user, setUser] = useState('');
  const [isValid, setIsValid] = useState(false);

  const validateUser = (value) => {
    const cleanUser = value.replace(/\D/g, '');

    const USER_REGEX = /^(\d{3})(\d{3})(\d{3})(\d{2})$/;
    
    if (cleanUser.length !== 11 || !USER_REGEX.test(cleanUser)) {
      return false;
    }

    const calculateDigit = (slice, multipliers) => {
      const sum = slice
        .split('')
        .map((digit, index) => parseInt(digit) * multipliers[index])
        .reduce((acc, value) => acc + value, 0);
      
      const remainder = sum % 11;
      return remainder < 2 ? 0 : 11 - remainder;
    };

    const firstDigit = calculateDigit(cleanUser.slice(0, 9), [10, 9, 8, 7, 6, 5, 4, 3, 2]);
    const secondDigit = calculateDigit(cleanUser.slice(0, 9) + firstDigit, [11, 10, 9, 8, 7, 6, 5, 4, 3, 2]);

    return firstDigit === parseInt(cleanUser[9]) && 
           secondDigit === parseInt(cleanUser[10]);
  };

  const handleUserChange = (e) => {
    const inputValue = e.target.value;
    
    const formattedUser = inputValue
      .replace(/\D/g, '')
      .replace(/(\d{3})(\d)/, '$1.$2')
      .replace(/(\d{3})(\d)/, '$1.$2')
      .replace(/(\d{3})(\d{2})/, '$1-$2')
      .slice(0, 14);

    setUser(formattedUser);
    setIsValid(validateUser(formattedUser.replace(/\D/g, '')));
  };
  const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;
  const CRM_REGEX = /^[A-Z]{2}\d{4,6}$/;
  const COREN_REGEX = /^[A-Z]{2}\d{4,6}$/;

  const userRef = useRef();
  const errRef = useRef();

  const [activeLogin, setActiveLogin] = useState("usuario");
  const [pwd, setPwd] = useState("");
  const [crm, setCrm] = useState("");
  const [coren, setCoren] = useState("");
  const [validName, setValidName] = useState(false);
  const [userFocus, setUserFocus] = useState(false);

  const [matchPwd, setMatchPwd] = useState("");
  const [validPwd, setValidPwd] = useState(false);
  const [validMatch, setValidMatch] = useState(false);
  const [matchFocus, setMatchFocus] = useState(false);
  const [pwdFocus, setPwdFocus] = useState(false);

  const [validCrm, setValidCrm] = useState(false);
  const [crmFocus, setCrmFocus] = useState(false);

  const [validCoren, setValidCoren] = useState(false);
  const [corenFocus, setCorenFocus] = useState(false);

  const [errMsg, setErrMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []);

  useEffect(() => {
    const result = USER_REGEX.test(user);
    setValidName(result);
  }, [user]);

  useEffect(() => {
    const result = PWD_REGEX.test(pwd);
    setValidPwd(result);
    const match = pwd === matchPwd;
    setValidMatch(match);
  }, [pwd, matchPwd]);

  useEffect(() => {
    const result = CRM_REGEX.test(crm);
    setValidCrm(result);
  }, [crm]);

  useEffect(() => {
    const result = COREN_REGEX.test(coren);
    setValidCoren(result);
  }, [coren]);

  useEffect(() => {
    setErrMsg("");
  }, [user, pwd, matchPwd, crm, coren]);

  

const URL_API = 'http://localhost:3000/api/auth';

const handleSubmit = async (e) => {
  e.preventDefault();
  
  try {
    const resposta = await axios.post(`${URL_API}/login`, {
      username: user,
      password: pwd,
      ...(activeLogin === "medico" && { crm }),
      ...(activeLogin === "enfermeiro" && { coren })
    });

    // Armazena token no localStorage
    localStorage.setItem('token', resposta.data.token);
    
    // Define cabeçalho padrão para futuras requisições
    axios.defaults.headers.common['Authorization'] = `Bearer ${resposta.data.token}`;

    // Redireciona ou atualiza estado do app
    setSuccess(true);
  } catch (err) {
    setErrMsg('Falha no login');
  }
};

// Interceptor para tratar requisições não autorizadas
axios.interceptors.response.use(
  resposta => resposta,
  erro => {
    if (erro.response.status === 401) {
      // Token expirou ou é inválido, faz logout
      localStorage.removeItem('token');
      // Redireciona para login
    }
    return Promise.reject(erro);
  }
);

// Função para verificar validade do token
const verificarValidadeToken = () => {
  const token = localStorage.getItem('token');
  return token && !tokenExpirado(token);
};

  const toggleLoginType = (type) => {
    setActiveLogin(type);
    // Resetar todos os estados
    setUser("");
    setPwd("");
    setMatchPwd("");
    setCrm("");
    setCoren("");
    setValidName(false);
    setValidPwd(false);
    setValidMatch(false);
    setValidCrm(false);
    setValidCoren(false);
  };

  return (
    <div className="min-h-screen bg-white flex justify-center items-center ">
      <div className="w-full max-w-md p-8 bg-white shadow-lg rounded-lg border-solid border-2 border-black">
        <div className="text-center mb-6 bg-white" >
          <h1 className="text-4xl text-black font-bold mb-2 flex items-center justify-center"><FaUser className="mr-2" /> Login</h1>
          <hr className="mb-4" />
          {["usuario", "medico", "enfermeiro"].map((type) => (
            <button
              key={type}
              onClick={() => toggleLoginType(type)}
              className={`${
                activeLogin === type 
                  ? 'bg-blue-600 text-white' 
                  : 'bg-gray-200 text-blue-600'
              } px-4 py-2 rounded-md mr-2 mb-2 transition-colors`}
            >
              {type === "usuario" ? "Usuário" : type === "medico" ? "Médico" : "Enfermeiro"}
            </button>
          ))}
        </div>

        <form onSubmit={handleSubmit}>
        <div className="mb-4">
            <label htmlFor="username" className="block text-sm font-medium text-white-600">CPF</label>
            <input
              ref={userRef}
              type="text"
              value={user}
              onChange={handleUserChange}
              onFocus={() => setUserFocus(true)}
              onBlur={() => setUserFocus(false)}
              placeholder="Digite seu CPF"
              className={`w-full p-3 mt-1 border ${isValid ? 'border-green-500' : 'border-red-500'} rounded-lg`}
            />
            {userFocus && user && !validName && (
              <p className="text-red-600 text-sm mt-1">
                <FaInfoCircle className="inline-block mr-1" />
                CPF precisa ser válido
              </p>
            )}
          </div>

          <div className="mb-4">
            <label htmlFor="password" className="block text-sm font-medium text-white-600">Senha</label>
            <input
              type="password"
              id="password"
              value={pwd}
              onChange={(e) => setPwd(e.target.value)}
              onFocus={() => setPwdFocus(true)}
              onBlur={() => setPwdFocus(false)}
              className="w-full p-3 mt-1 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400"
              placeholder="****"
            />
            {pwdFocus && pwd && !validPwd && (
              <p className="text-red-600 text-sm mt-1">
                <FaInfoCircle className="inline-block mr-1" />
                8 a 24 caracteres. Inclua maiúsculas, minúsculas, número e caractere especial.
              </p>
            )}
          </div>

          <div className="mb-4">
            <label htmlFor="confirm_pwd" className="block text-sm font-medium text-white-600">Confirmar Senha</label>
            <input
              type="password"
              id="confirm_pwd"
              value={matchPwd}
              onChange={(e) => setMatchPwd(e.target.value)}
              onFocus={() => setMatchFocus(true)}
              onBlur={() => setMatchFocus(false)}
              className="w-full p-3 mt-1 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400"
            />
            {matchFocus && matchPwd && !validMatch && (
              <p className="text-red-600 text-sm mt-1">
                <FaInfoCircle className="inline-block mr-1" />
                Senhas não correspondem.
              </p>
            )}
            <a href="#" className="text-black text-sm">Esqueci a Senha?</a>
          </div>

          {activeLogin === "medico" && (
            <div className="mb-4">
              <label htmlFor="crm" className="block text-sm font-medium text-white-600">CRM</label>
              <input
                type="text"
                id="crm"
                value={crm}
                onChange={(e) => setCrm(e.target.value.toUpperCase())}
                onFocus={() => setCrmFocus(true)}
                onBlur={() => setCrmFocus(false)}
                className="w-full p-3 mt-1 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400"
                placeholder="CRM/SP 123456"
              />
              {crmFocus && crm && !validCrm && (
                <p className="text-red-600 text-sm mt-1">
                  <FaInfoCircle className="inline-block mr-1" />
                  CRM deve conter sigla do estado e 4 a 6 dígitos.
                </p>
              )}
            </div>
          )}

          {activeLogin === "enfermeiro" && (
            <div className="mb-4">
              <label htmlFor="coren" className="block text-sm font-medium text-white-600">COREN</label>
              <input
                type="text"
                id="coren"
                value={coren}
                onChange={(e) => setCoren(e.target.value.toUpperCase())}
                onFocus={() => setCorenFocus(true)}
                onBlur={() => setCorenFocus(false)}
                className="w-full p-3 mt-1 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400"
                placeholder="COREN/SP 123456"
              />
              {corenFocus && coren && !validCoren && (
                <p className="text-red-600 text-sm mt-1">
                  <FaInfoCircle className="inline-block mr-1" />
                  COREN deve conter sigla do estado e 4 a 6 dígitos.
                </p>
              )}
            </div>
          )}

          <button
            type="submit"
            disabled={
              !validName || 
              !validPwd || 
              !validMatch || 
              (activeLogin === "medico" && !validCrm) ||
              (activeLogin === "enfermeiro" && !validCoren)
            }
            className="w-full py-3 text-white bg-blue-600 rounded-lg hover:bg-blue-700 disabled:bg-gray-300"
          >
            Cadastrar
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;

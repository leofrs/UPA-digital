import React, { useRef, useState, useEffect } from "react";
import { FaCheckCircle, FaTimes, FaInfoCircle } from "react-icons/fa";

function Login() {
  const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/;
  const PWD_REGEX = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/;

  const userRef = useRef();
  const errRef = useRef();

  const [user, setUser] = useState("");
  const [pwd, setPwd] = useState("");
  const [validName, setValidName] = useState(false);
  const [userFocus, setUserFocus] = useState(false);

  const [matchPwd, setMatchPwd] = useState("");
  const [validPwd, setValidPwd] = useState(false);
  const [validMatch, setValidMatch] = useState(false);
  const [matchFocus, setMatchFocus] = useState(false);
  const [pwdFocus, setPwdFocus] = useState(false);

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
    setErrMsg("");
  }, [user, pwd, matchPwd]);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Formulário enviado", { user, pwd });
  };

  return (
    <div className="container">
      <p
        ref={errRef}
        className={errMsg ? "errmsg" : "offscreen"}
        aria-live="assertive"
      >
        {errMsg}
      </p>
      <h1>Registrar</h1>
      <form onSubmit={handleSubmit} method="post">
        <label htmlFor="username">
          Nome de Usuário:
          {user && (validName ? <FaCheckCircle /> : <FaTimes />)}
        </label>
        <input
          type="text"
          id="username"
          ref={userRef}
          autoComplete="off"
          aria-invalid={validName ? "false" : "true"}
          aria-describedby="uidnote"
          onFocus={() => setUserFocus(true)}
          onBlur={() => setUserFocus(false)}
          value={user}
          onChange={(e) => setUser(e.target.value)}
        />
        <p
          id="uidnote"
          className={
            userFocus && user && !validName ? "instructions" : "offscreen"
          }
        >
          <FaInfoCircle />
          4 a 24 letras. <br />
          Deve começar com uma letra. <br />
          Letras, números, underline e hífens permitidos.
        </p>

        <label htmlFor="password">
          Senha:
          {pwd && (validPwd ? <FaCheckCircle /> : <FaTimes />)}
        </label>
        <input
          type="password"
          id="password"
          onChange={(e) => setPwd(e.target.value)}
          value={pwd}
          required
          aria-invalid={validPwd ? "false" : "true"}
          aria-describedby="pwdnote"
          onFocus={() => setPwdFocus(true)}
          onBlur={() => setPwdFocus(false)}
        />
        <p
          id="pwdnote"
          className={pwdFocus && pwd && !validPwd ? "instructions" : "offscreen"}
        >
          <FaInfoCircle />
          8 a 24 caracteres.
          <br />
          Deve incluir letras maiúsculas e minúsculas, um número e um caractere especial.
          <br />
          Caracteres especiais permitidos:{" "}
          <span aria-label="ponto de exclamação">!</span>{" "}
          <span aria-label="arroba">@</span>{" "}
          <span aria-label="hashtag">#</span>{" "}
          <span aria-label="cifrão">$</span>{" "}
          <span aria-label="porcentagem">%</span>
        </p>

        <label htmlFor="confirm_pwd">
          Confirmar Senha:
          {matchPwd && (validMatch ? <FaCheckCircle /> : <FaTimes />)}
        </label>
        <input
          type="password"
          id="confirm_pwd"
          onChange={(e) => setMatchPwd(e.target.value)}
          value={matchPwd}
          required
          aria-invalid={validMatch ? "false" : "true"}
          aria-describedby="confirmnote"
          onFocus={() => setMatchFocus(true)}
          onBlur={() => setMatchFocus(false)}
        />
        <p
          id="confirmnote"
          className={matchFocus && matchPwd && !validMatch ? "instructions" : "offscreen"}
        >
          <FaInfoCircle />
          Deve corresponder ao primeiro campo de senha.
        </p>

        <button
          disabled={!validName || !validPwd || !validMatch}
        >
          Cadastrar
        </button>
      </form>
    </div>
  );
}

export default Login;
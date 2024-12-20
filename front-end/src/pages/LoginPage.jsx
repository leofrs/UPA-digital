import React, { useState } from "react";
import { z } from "zod";
import axios from "axios";
import LoginPatient from "@/components/auth/Login-Patient";
import LoginDoctor from "@/components/auth/Login-Doctor";
import LoginRecepptionist from "@/components/auth/Login-Recepptionist";


function LoginPage() {
    const infos = [{id:1, nome:"patient"},{id:2, nome:"doctor"}, {id:3, nome:"recepptionist"}]
    const[open, setOpen] = useState("patient")
    const [activeLogin, setActiveLogin] = useState(infos.nome);

    //teste
       

    return (
        <div className="flex flex-col justify-center items-center h-screen bg-gray-100">
           
                

                 <div className="flex justify-center mb-2">
                    {infos.map((type) => (
                        <button onClick={() => (setOpen(type.nome))}
                            key={type.id}
                        
                            className={`${
                                activeLogin === type
                                    ? 'bg-blue-500 text-white'
                                    : 'bg-blue-300 text-white'
                            } px-4 py-2 rounded-md mr-2 mb-2 transition-colors hover:opacity-90`}
                        >
                            {type.nome}
                            
                        </button>
                    ))}
                </div> 
                
                
                {open == "patient" ? <LoginPatient/> : open =="doctor" ? <LoginDoctor/> : open == "recepptionist" ? <LoginRecepptionist/> : <LoginPatient/>}

                
                
        </div>
    );
}

export default LoginPage;

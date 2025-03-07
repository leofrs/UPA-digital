import { useState } from "react";
import { allDoctors } from "@/data/tableAllDoctors";
import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";
import axios from "axios";

const MakeAnAppointment = () => {

  const [selectedDoctor, setSelectedDoctor] = useState(null);
  const [formStatus, setFormStatus] = useState({ show: false, success: false, message: "" });

  //const URL_API = 'http://localhost:8080/api/v1/login/login';

  const validationSchema = z.object({
    medico: z.string().nonempty("É obrigatório selecionar um médico"),
    data: z.string().nonempty("É obrigatório selecionar uma data para a consulta"),
    descricao: z.string().nonempty("É Obrigatório dizer o motivo da consulta"),
  });

  const {
    register,
    handleSubmit,
    setValue,
    formState: { errors },
  } = useForm({
    resolver: zodResolver(validationSchema), // Adicionado o resolver do Zod
    defaultValues: {
      medico: "",
      data: "",
      descricao: "",
    }
  });

  const handleDoctorChange = (event) => {
    const selectedValue = event.target.value;
    const doctor = allDoctors.find((doc) => doc.nome === selectedValue);
    setSelectedDoctor(doctor);
    setValue("medicos", selectedValue);
  };

  const onSubmit = async (data) => {
    try {
      // Validar se todos os campos estão preenchidos
      if (!data.medico || !data.data || !data.descricao) {
        setFormStatus({
          show: true,
          success: false,
          message: "Por favor, preencha todos os campos obrigatórios."
        });
        return;
      }
  
      // Criar objeto com todos os dados, incluindo especialidade e posto do médico selecionado
      const appointmentData = {
        ...data,
        id:selectedDoctor.id,
        especialidade: selectedDoctor.especialidade,
        posto: selectedDoctor.posto,
        contato: selectedDoctor.contato

      };
      console.log("Dados antes de enviar:", appointmentData);
  
     
 
      
      setFormStatus({
        show: true,
        success: true,
        message: "Consulta marcada com sucesso! Em breve você receberá um email de confirmação."
      });
  
    } catch (error) {
      setFormStatus({
        show: true,
        success: false,
        message: "Erro ao marcar consulta. Por favor, tente novamente."
      });
    }
  };

  const onError = () => {
    setFormStatus({
      show: true,
      success: false,
      message: "Por favor, preencha todos os campos obrigatórios."
    });
  };

  return (
    <div className="flex justify-center items-center w-11/12 bg-gray min-h-screen">
      <div className="w-9/12 bg-white rounded-lg shadow-lg p-8">
        <h1 className="text-2xl font-bold text-center text-blue-700 mb-6">Marcar Consulta</h1>

        {formStatus.show && (
          <div
            className={`mb-6 p-4 rounded-lg border ${
              formStatus.success 
                ? "bg-green-50 border-green-200 text-green-800" 
                : "bg-red-50 border-red-200 text-red-800"
            }`}
            role="alert"
          >
            <p className="text-sm font-medium">{formStatus.message}</p>
          </div>
        )}

        <form
          onSubmit={handleSubmit(onSubmit, onError)}
          className="w-full max-w-100 p-8 bg-white rounded-2xl shadow-2xl border border-gray-100"
        >
          <div className="space-y-6">
            <div>
              <label htmlFor="medico" className="block text-sm font-medium text-gray-600 mb-2">
                Médico:
              </label>
              <select
                id="medico"
                {...register("medico")}
                onChange={handleDoctorChange}
                className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl ${errors.medico ? "border-red-400" : "border-gray-200"}`}
              >
                <option value="">Selecione um médico</option>
                {allDoctors.map((doctor) => (
                  <option key={doctor.id} value={doctor.nome}>
                    {doctor.nome} - {doctor.especialidade} ({doctor.posto})
                  </option>
                ))}
              </select>
              {errors.medico && (
                <div className="text-red-500 text-sm mt-2">{errors.medico.message}</div>
              )}
            </div>

            {selectedDoctor && (
              <div className="p-4 bg-gray-100 border border-gray-300 rounded-lg mt-4">
                <h2 className="text-lg font-bold text-blue-600">Informações do Médico:</h2>
                <p><strong>Nome:</strong> {selectedDoctor.nome}</p>
                <p><strong>Especialidade:</strong> {selectedDoctor.especialidade}</p>
                <p><strong>Posto:</strong> {selectedDoctor.posto}</p>
                <p><strong>Contato:</strong> {selectedDoctor.contato || "Não informado"}</p>
              </div>
            )}

            <div>
              <label htmlFor="data" className="block text-sm font-medium text-gray-600 mb-2">
                Data para consulta:
              </label>
              <input
                type="datetime-local"
                id="data"
                {...register("data")}
                className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl ${errors.data ? "border-red-400" : "border-gray-200"}`}
              />
              {errors.data && (
                <div className="text-red-500 text-sm mt-2">{errors.data.message}</div>
              )}
            </div>

            <div>
              <label htmlFor="descricao" className="block text-sm font-medium text-gray-600 mb-2">
                Motivo da consulta:
              </label>
              <textarea
                id="descricao"
                cols="70"
                rows="5"
                {...register("descricao")}
                className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl ${errors.descricao ? "border-red-400" : "border-gray-200"}`}
              ></textarea>
              {errors.descricao && (
                <div className="text-red-500 text-sm mt-2">{errors.descricao.message}</div>
              )}
            </div>

            <button
              type="submit"
              className="w-full py-3 px-4 bg-blue-600 text-white font-bold rounded-xl hover:bg-green-700 transition-all duration-300"
            >
              Confirmar Consulta
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default MakeAnAppointment;
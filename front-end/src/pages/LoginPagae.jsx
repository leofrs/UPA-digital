import { useForm } from "react-hook-form";
import { z } from "zod";
import { zodResolver } from "@hookform/resolvers/zod";

const loginSchema = z.object({
    cartaoSus: z
        .string()
        .length(15, "O cartão do SUS deve conter exatamente 15 números")
        .regex(/^\d+$/, "O cartão do SUS deve conter apenas números"),
    password: z.string().min(6, "A senha deve conter pelo menos 6 caracteres"),
});

function LoginPage() {
    const {
        register,
        handleSubmit,
        formState: { errors },
    } = useForm({
        resolver: zodResolver(loginSchema),
    });

    const onSubmit = (data) => console.log(data);

    return (
        <div className="flex justify-center items-center h-screen bg-gray-100">
            <form
                onSubmit={handleSubmit(onSubmit)}
                className="w-full max-w-md p-8 bg-gradient-to-br from-blue-50 to-white rounded-2xl shadow-2xl border border-gray-100"
            >
                <div className="text-center mb-8">
                    <h2 className="text-3xl font-extrabold text-gray-800 mb-2">Entrar</h2>
                    <p className="text-gray-500">Acesse sua conta colocando as credênciais abaixo</p>
                </div>

                <div className="space-y-6">
                    <div>
                        <label htmlFor="cartaoSus" className="block text-sm font-medium text-gray-600 mb-2">
                            Cartão do SUS
                        </label>
                        <input
                            id="cartaoSus"
                            type="text"
                            {...register("cartaoSus")}
                            className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl transition-all duration-300 
                    ${
                        errors.cartaoSus
                            ? "border-red-400 focus:ring-red-200"
                            : "border-gray-200 focus:border-blue-400 focus:ring-blue-200"
                    } 
                    focus:outline-none focus:ring-2`}
                            placeholder="Digite seu número do cartão"
                        />
                        {errors.cartaoSus && (
                            <div className="flex items-center text-red-500 text-sm mt-2">
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="h-4 w-4 mr-2"
                                    viewBox="0 0 20 20"
                                    fill="currentColor"
                                >
                                    <path
                                        fillRule="evenodd"
                                        d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z"
                                        clipRule="evenodd"
                                    />
                                </svg>
                                {errors.cartaoSus.message}
                            </div>
                        )}
                    </div>

                    <div>
                        <label htmlFor="password" className="block text-sm font-medium text-gray-600 mb-2">
                            Senha
                        </label>
                        <input
                            id="password"
                            type="password"
                            {...register("password")}
                            className={`w-full px-4 py-3 bg-gray-50 border-2 rounded-xl transition-all duration-300 
                    ${
                        errors.password
                            ? "border-red-400 focus:ring-red-200"
                            : "border-gray-200 focus:border-blue-400 focus:ring-blue-200"
                    } 
                    focus:outline-none focus:ring-2`}
                            placeholder="Digite sua senha"
                        />
                        {errors.password && (
                            <div className="flex items-center text-red-500 text-sm mt-2">
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    className="h-4 w-4 mr-2"
                                    viewBox="0 0 20 20"
                                    fill="currentColor"
                                >
                                    <path
                                        fillRule="evenodd"
                                        d="M18 10a8 8 0 11-16 0 8 8 0 0116 0zm-7-4a1 1 0 11-2 0 1 1 0 012 0zM9 9a1 1 0 000 2v3a1 1 0 001 1h1a1 1 0 100-2v-3a1 1 0 00-1-1H9z"
                                        clipRule="evenodd"
                                    />
                                </svg>
                                {errors.password.message}
                            </div>
                        )}
                    </div>

                    <button
                        type="submit"
                        className="w-full py-3 px-4 bg-blue-600 text-white font-bold rounded-xl 
            hover:bg-blue-700 transition-all duration-300 
            focus:outline-none focus:ring-2 focus:ring-blue-400 focus:ring-opacity-50 
            transform hover:scale-[1.02] active:scale-[0.98] shadow-lg hover:shadow-xl"
                    >
                        Entrar
                    </button>
                </div>
            </form>
        </div>
    );
}

export default LoginPage;

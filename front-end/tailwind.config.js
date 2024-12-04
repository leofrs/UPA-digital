/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./pages//*.{js,jsx,ts,tsx}",
    "./components//.{js,jsx,ts,tsx}",
    "./src/**/.{html,css,js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        white: '#ffffff', // Assegura que o branco será realmente branco
      },
    },
  },
  plugins: [],
}

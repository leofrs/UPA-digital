class DoctorApi {
    static async getDoctors() {
        await fetch('http://localhost:8080/home/make-appointment').then((response) => {
            return response.json();
        }).then((data) => {
            console.log(data);
        }).catch((error) => {
            console.error('Error:', error);
        });
    }
}
export default DoctorApi;
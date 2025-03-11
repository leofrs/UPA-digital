class DoctorApi {
  static async getDoctors() {
    await fetch("http://localhost:8080//api/v1/doctor/all-doctor")
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }
}
export default DoctorApi;

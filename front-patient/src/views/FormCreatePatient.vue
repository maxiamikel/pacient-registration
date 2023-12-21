<template>
    <main>
        <div class="my-5">
            <div class="mx-auto w-25" style="max-width:100%;">
                <h3 class="text-center mb-3">Add Patient</h3>
                <form @submit.prevent="addPatient">
                    <div class="row">
                        <div class="col-md-12 form-group mb-3">
                            <label for="name" class="form-label">Name</label>
                            <input type="text" name="name" class="form-control" placeholder="Name" required v-model="patient.name">
                        </div>

                        <div class="col-md-12 form-group mb-3">
                            <label for="personalNumber" class="form-label">Personal Number</label>
                            <input type="text" name="personalNumber" class="form-control" placeholder="Personal Number" required v-model="patient.personalNumber">
                        </div>

                        <div class="col-md-12 form-group mb-3">
                            <label for="gender" class="form-label">Gender</label>
                            <div class="form-check">
                                <input type="radio" name="gender" id="male" value="male" v-model="patient.gender">
                                <label for="male" class="form-check-lavel">Male</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" name="gender" id="female" value="female" v-model="patient.gender">
                                <label for="female" class="form-check-lavel">Female</label>
                            </div>
                            <div class="form-check">
                                <input type="radio" name="gender" id="others" value="others" v-model="patient.gender">
                                <label for="others" class="form-check-lavel">Others</label>
                            </div>
                        </div>

                        <div class="col-md-12 form-group mb-3">
                            <label for="telephone" class="form-label">Phone Number</label>
                            <input type="text" name="telephone" class="form-control" placeholder="Phone Number" required v-model="patient.telephone">
                        </div>

                        <div class="col-md-12 form-group mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="text" name="email" class="form-control" placeholder="Ex: amikelmaxi@email.com" required v-model="patient.email">
                        </div>

                        <div class="col-md-12 form-group mb-3">
                            <label for="birthday" class="form-label">Birth date</label>
                            <input type="date" name="birthDate" class="form-control"  required v-model="patient.birthDate">
                        </div>
                        <input type="hidden" name="registDate"/>
                        <div class="col-md-12 form-group mb-3">
                            <label for="diagnosis" class="form-label">Birth date</label>
                            <input type="text" name="diagnosis" class="form-control" placeholder="Diagnosis"  required v-model="patient.diagnosis">
                        </div>

                         <div class="col-md-12 form-group mb-3">
                            <input type="submit" value="Submit" class="btn btn-primary w-100">
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

<script>
export default {
   name: 'FormCreatePatient',
   components:{

   },
   data(){
    return{
        patient: {
            name:'',
            personalNumber:'',
            email:'',
            telephone:'',
            gender:'',
            birthDate:'',
            registDate:'',
            diagnosis:''
        }
    }
    
   },
   methods: {
    addPatient(){
        fetch('http://localhost:8080/patients/add',{
            method:'POST',
            headers:{
                'content-type':'application/json'
            },
            body: JSON.stringify(this.patient)
        })
        .then(data => {
            this.$router.push('/')
           // console.log(data)
        })
    }
   }
}
</script>

<style scoped>
    .form-check-lavel{
        margin-left: 15px;
    }
</style>
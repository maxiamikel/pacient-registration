<template>
    <main>
         <div class="my-5">
            <div class="mx-auto w-25" style="max-width:100%;">
                <h3 class="text-center mb-3">Edit Patient [{{patient.id}}]</h3>
                <form @submit.prevent="updatePatient">
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
                            <input type="submit" value="Update" class="btn btn-primary w-100">
                        </div>

                    </div>
                </form>
            </div>
        </div>
    </main>
</template>

<script>
export default {
    name:'UpdatePatient',
    data(){
        return{
            patient:{
                name:'',
                personalNumber:'',
                email:'',
                telephone:'',
                gender:''
            }
        }
    },
    methods:{
        getPatient(){
            fetch(`http://localhost:8080/patients/${this.$route.params.id}`)
            .then( res => res.json())
            .then(data => {
                this.patient = data
            })
        },
        updatePatient(){
            fetch(`http://localhost:8080/patients/update/${this.$route.params.id}`,{
                method:'PUT',
                headers:{
                    'content-type':'application/json'
                },
                body: JSON.stringify(this.patient)
            })
            .then(data =>{
                console.log(this.data)
                this.$router.push('/')
            })
        }
    },
    beforeMount(){
        this.getPatient();
    }
}
</script>
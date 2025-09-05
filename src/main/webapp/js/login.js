const loading = {
    container: document.getElementById("loading"),
    in(){
        this.container.classList.remove("loading_out");
    },
    out() {
        this.container.classList.add("loading_out");
    }
};

window.addEventListener("load", () => {
    loading.out();
})
window.addEventListener("submit",() =>{
    loading.in();
})
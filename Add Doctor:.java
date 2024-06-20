#Snippet code of Add Doctor:
private void addDoctors(Context context, final String id) {
final Dialog dialog = new Dialog(ViewHospital.this);
dialog.setContentView(R.layout.activity_add_doctor);
dialog.setTitle("Update"+id);
final EditText etdoctorname=dialog.findViewById(R.id.etdoctorname);
final EditText etexp=dialog.findViewById(R.id.etexp);
Button btadd=dialog.findViewById(R.id.btadd);
final Spinner spinner=dialog.findViewById(R.id.spinner);
String
s[]={"cardialogist","gynacologist","Neurologists","Dermatologists","Anesthesiologists
","Colon and Rectal Surgeons","Pathologists","Plastic Surgeons "};
ArrayAdapter arrayAdapter=new
ArrayAdapter(context,android.R.layout.simple_dropdown_item_1line,s);
spinner.setAdapter(arrayAdapter);
btadd.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
final String docname=etdoctorname.getText().toString();
final String spec=spinner.getSelectedItem().toString();
final String exp=etexp.getText().toString();
if(docname.isEmpty() || docname == null) {
etdoctorname.setError("Enter Username");
}else if(exp.isEmpty()||exp==null){
etexp.setError("Enter Experience");
}else {
Log.e("key is", id);
databaseReference =
FirebaseDatabaseConnection.databaseconnection("nearhospital");
final ProgressDialog progressDialog = new ProgressDialog(ViewHospital.this);
progressDialog.setTitle("connecting...");
progressDialog.show();
databaseReference.child(id).addListenerForSingleValueEvent(new
ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
Hospital hospital = dataSnapshot.getValue(Hospital.class);
doctors = new ArrayList<>();
doctor = new Doctor(docname, spec, exp);
doctors.add(doctor);
if (hospital.getDoctorList() == null) {
hospital.setDoctorList(doctors);
} else {
hospital.getDoctorList().add(doctor);
}
databaseReference.child(id).setValue(hospital);
ToastHelper.toastMsg(getApplicationContext(), "doctor added");
dialog.dismiss();
progressDialog.dismiss();
}

@Override
public void onCancelled(@NonNull DatabaseError databaseError) {
progressDialog.dismiss();
}
});
}
}
});
int width = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.95);
int height = (int) (context.getResources().getDisplayMetrics().heightPixels * 0.6);
dialog.getWindow().setLayout(width, height);
dialog.show();
}
}
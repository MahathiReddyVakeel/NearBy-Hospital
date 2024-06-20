//Snippet code of Specialization:
protected void onCreate(@Nullable Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_success_login);
requestStoragePermission();
nearHospitalModels=new ArrayList<>();
lvlist=findViewById(R.id.lvlist);
s=new
String[]{"cardialogist","gynacologist","Neurologists","Dermatologists","Anesthesiologi
sts ","Colon and Rectal Surgeons","Pathologists","Plastic Surgeons "};
ArrayAdapter arrayAdapter=new
ArrayAdapter(this,android.R.layout.simple_list_item_1,s);
lvlist.setAdapter(arrayAdapter);
lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
Intent i1=new Intent(getApplicationContext(),NearByHospital.class);
i1.putExtra("spec",s[i]);
startActivity(i1);
}
});
}
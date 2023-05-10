job('First_Maven_Project_DSL')
{
	description("First maven project via DSL")
	scm
	{
<<<<<<< HEAD
		github('https://github.com/Saba-Perween/2nd-git-repo.git', 'dev')
=======
		git('https://github.com/Saba-Perween/2nd-git-repo.git', 'dev')
>>>>>>> e34593c462b4ebfc331ab0cad4734a3c6a90eaf1
	}
	triggers
	{
		scm('* * * * *')
	}
	steps
	{
		maven('clean package', 'webprojectapi/pom.xml')
	}
	publisher
	{
		archiveArtifacts '**/*.war'
	}
}

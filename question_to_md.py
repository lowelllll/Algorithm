# 백준이나 프로그래머스에 있는 내용을 토대로 알고리즘 문제 풀이 파일을 만듬
import requests
import tomd

class AlgorithmMd():
	SITE = {
		'백준': {
			'name': 'backjoon',
			'base_url': 'https://www.acmicpc.net/problem/'
		},
		'프로그래머스' : {'name': 'programmers'} # 프로그래머스의 문제 url은 일정하지 않기때문에 따로 입력 필요 
	}

	def __init__(self, site, q_num, lang):
		self.site = site
		self.q_num = q_num
		self.lang = lang

	def question_to_md(self):
		with open('template.md', 'r') as template_md:
			template = template_md.read()

		template = template.format(
			q_num=self.q_num,
			lang=self.lang,
			site=AlgorithmMd.SITE[self.site]['name'],
			q_name='',
			type='',
			question='',
			input='',
			output='',
			sample_input='',
			sample_output=''
		)

		print(template)

	def question_crawler(self):
		pass


if __name__ == '__main__':
	am = AlgorithmMd('백준', 1004, 'java')
	am.question_to_md()